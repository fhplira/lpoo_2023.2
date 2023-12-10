package controladores;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dados.ExcecaoDados;
import dados.LivroDados;
import modelos.LivroModelo;


public class LivroControlador {
		
		private LivroDados dados = new LivroDados() ;
	

		public void cadastrarLivroPorISBN(String isbn) throws ExcecaoControlador, IOException{	

			verificarIsbn(isbn); 

			LivroModelo livro = buscarLivroApi(isbn);
			livro.setAdicionarDisponivel(1);
			livro.setEmprestado(0);
			livro.setValorTotal();

			try {
				dados.cadastrarLivro(livro);			
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			} 

		}


		private LivroModelo buscarLivroApi(String isbn) throws ExcecaoControlador, MalformedURLException, IOException {
			
			final String urlGet = "https://www.googleapis.com/books/v1/volumes?q=+isbn:"+isbn+"&key=AIzaSyAgg6itGrlT3cWjIMrprDV6_nduS_NvTwY";
			HttpClient cliente = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(urlGet))
					.build();

			HttpResponse<String> response = null;

			try {
				response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
			} catch (Exception e) {
				throw new ExcecaoControlador("Houve uma inconsistência com a base de dados.");
			} 

			Gson gson = new Gson();
			JsonObject obj = gson.fromJson(response.body(), JsonObject.class);

			int verificaSeTemObjeto = obj.get("totalItems").getAsInt();


			if(verificaSeTemObjeto == 0) {
				throw new ExcecaoControlador("O isbn não foi encontrado na base de dados.");
			}


			Map map = gson.fromJson(obj.get("items").getAsJsonArray().get(0), Map.class);

			LivroModelo livro = new LivroModelo();

			if ((((Map) map.get("volumeInfo")).containsKey("imageLinks"))){	
				Map<String, String> img = (Map<String, String>)((Map) map.get("volumeInfo")).get("imageLinks");

				String urlImg = img.get("smallThumbnail");
				livro.setImg(urlImg);

				URL url = new URL(urlImg);
				URLConnection conexao = url.openConnection();

				String nomeArquivo = isbn;

				String caminhoPastaLivros = System.getenv("APPDATA") + "/" + Constantes.PASTA_APP + "/" + Constantes.PASTA_LIVROS;

				File file = new File(caminhoPastaLivros);
				if (!file.exists()) {
					file.mkdirs();
				}

				Path destinoPath = Path.of(caminhoPastaLivros, nomeArquivo);

				InputStream inputStream = conexao.getInputStream();
				Files.copy(inputStream, destinoPath, StandardCopyOption.REPLACE_EXISTING);        	
			}

			if((((Map) map.get("volumeInfo")).containsKey("publisher")) ) {
				livro.setEditora((String) ((Map) map.get("volumeInfo")).get("publisher"));
			}

			if((((Map) map.get("volumeInfo")).containsKey("publishedDate")) ) {
				livro.setDataPublicacao((String) ((Map) map.get("volumeInfo")).get("publishedDate"));
			}

			if((((Map) map.get("volumeInfo")).containsKey("description")) ) {
				livro.setDescricao((String) ((Map) map.get("volumeInfo")).get("description"));
			}

			livro.setTitulo((String)((Map) map.get("volumeInfo")).get("title"));
			livro.setAutor((String) ((Map) map.get("volumeInfo")).get("authors").toString());
			livro.setIsbn(isbn);	
			return livro;
		}


		private void verificarIsbn(String isbn) throws ExcecaoControlador {
			
			if(isbn.isBlank()){
					throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}
				
			if(!isbn.matches("^\\d+$")){
					throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
			}
						
			if((isbn.length() != 10) && (isbn.length() != 13)) {
					throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
			}	

			
			try{
			  	 if (dados.verificarLivro(isbn)){
			 		 throw new ExcecaoControlador("ISBN já cadastrado na base de dados.");
			 	}
			    
			}catch(ExcecaoDados e){
				  	 throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		
		public void cadastrarLivro(String isbn, String titulo, String autor, String editora, String dataPublicacao, String img, String descricao) throws ExcecaoControlador{

			LivroModelo livro = verficarCamposCadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao);
			livro.setAdicionarDisponivel(1);
			livro.setEmprestado(0);
			livro.setValorTotal();
			
			try {
				dados.cadastrarLivro(livro);			
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			} 
		}


		private LivroModelo verficarCamposCadastrarLivro(String isbn, String titulo, String autor, String editora, String dataPublicacao, String img, String descricao) throws ExcecaoControlador {

			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}

			if(!isbn.matches("^\\d+$")){
				throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
			}

			if((isbn.length() != 10) && (isbn.length() != 13)) {
				throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
			}


			if(titulo.isBlank()){
				throw new ExcecaoControlador("O campo título não pode ser vazio.");
			}

			if(autor.isBlank()){
				throw new ExcecaoControlador("O campo autor não pode ser vazio.");
			}

			if(!autor.matches("^[a-zA-Z,\\s]+$")){
				throw new ExcecaoControlador("O campo autor não pode ter números.");
			}

			if(!dataPublicacao.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$") && (!dataPublicacao.matches("^(\\D*\\d\\D*){4}$"))){
				throw new ExcecaoControlador("O campo data da publicação está inválida. Verifique se esta no formato correto dd/mm/yyyy ou yyyy");
			}


			try{
				if (dados.verificarLivro(isbn)){
					throw new ExcecaoControlador("ISBN já cadastrado na base de dados.");
				}
			}catch(ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			} 


   
			LivroModelo livro = new LivroModelo(isbn, titulo, autor, editora, dataPublicacao, descricao, img);
			return livro;
		}
		
		
		public void AdicionarExemplares(LivroModelo livro, String controleExemplar) throws ExcecaoControlador {

			if(livro.getIsbn().isBlank()){
				throw new ExcecaoControlador("O campo isbn não pode ser vazio.");
			}

			if(controleExemplar.isBlank()){
				throw new ExcecaoControlador("O campo quantidade não pode ser vazio.");
			}

			if(!controleExemplar.matches("^\\d+$")){
				throw new ExcecaoControlador("O campo quantidade não pode ter letras e nem espaços.");
			}
			int controleExemplarInteiro = Integer.parseInt(controleExemplar);
			
			if(controleExemplarInteiro < 0) {
				throw new ExcecaoControlador("A quantidade não pode ser menor que zero");
			}
			
			if(controleExemplarInteiro == 0) {
				throw new ExcecaoControlador("A quantidade não pode ser igual a zero");
			}
			
			LivroModelo exemplarLivro = new LivroModelo();
			
			try {
				exemplarLivro = dados.buscarLivroPorIsbn(livro.getIsbn());
				exemplarLivro.setAdicionarDisponivel(controleExemplarInteiro);
				exemplarLivro.setValorTotal();
				dados.acrescentarExemplarLivro(exemplarLivro, controleExemplarInteiro);
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			}

		}
		
		public void ExcluirExemplares(LivroModelo livro, String controleExemplar) throws ExcecaoControlador {

			if(livro.getIsbn().isBlank()){
				throw new ExcecaoControlador("O campo isbn não pode ser vazio.");
			}

			if(controleExemplar.isBlank()){
				throw new ExcecaoControlador("O campo quantidade não pode ser vazio.");
			}

			if(!controleExemplar.matches("^\\d+$")){
				throw new ExcecaoControlador("O campo quantidade não pode ter letras e nem espaços.");
			}
			
			int controleExemplarInteiro = Integer.parseInt(controleExemplar);
			
			if(controleExemplarInteiro < 0) {
				throw new ExcecaoControlador("A quantidade não pode ser menor que zero");
			}
			
			if(controleExemplarInteiro == 0) {
				throw new ExcecaoControlador("A quantidade não pode ser igual a zero");
			}
			
			if(controleExemplarInteiro > livro.getTotal()) {
				throw new ExcecaoControlador("Quantidade informada é maior do que exemplares existentes"
			+ "\n Quantidade de livro: " + livro.getTotal());
			}
			
			if(livro.getTotal() == 0) {
				throw new ExcecaoControlador("Nao existe exeplares para exclusão");
			}
			
			LivroModelo exemplarLivro = new LivroModelo();
			
			try {
				exemplarLivro = dados.buscarLivroPorIsbn(livro.getIsbn());
				exemplarLivro.setRemoverDisponivel(controleExemplarInteiro);
				exemplarLivro.setValorTotal();
				dados.deletarExemplarLivro(exemplarLivro, controleExemplarInteiro);

			}catch (ExcecaoDados e){
				 throw new ExcecaoControlador(e.getMessage(), e);
			}

			 
}
	
	
		public List<LivroModelo> buscarTodosOsLivros() throws ExcecaoControlador{

			try {
				return dados.buscarTodosOsLivros();
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		
		public LivroModelo buscarLivroPorIsbn(String isbn) throws ExcecaoControlador {
					
			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}

			if(!isbn.matches("^\\d+$")){
				throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
			}

			if((isbn.length() != 10) && (isbn.length() != 13)) {
				throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
			}

			try {
				return dados.buscarLivroPorIsbn(isbn);		
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		
		
		public LivroModelo buscarLivroPorTitulo(String titulo) throws ExcecaoControlador {

			if(titulo.isBlank()){
				throw new ExcecaoControlador("O campo título não pode ser vazio.");
			}

			try {
				return dados.buscarLivroPorTitulo(titulo);			
			}catch (ExcecaoDados e){
				throw new ExcecaoControlador(e.getMessage(), e);
			}	
		}	
}		

