package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.LivroModelo;

public class LivroControlador {
		
		public void cadastrarLivroPorISBN(String isbn) throws ExcecaoController{	
			
			if(isbn.isBlank()){
				throw new ExcecaoController("O campo ISBN não pode ser vazio.");
			}
			
			if(!isbn.matches("^\\d+$")){
				throw new ExcecaoController("O campo ISBN não pode ter letras e nem espaços.");
			}
			
			if((isbn.length() != 10) && (isbn.length() != 13)) {
				throw new ExcecaoController("O campo ISBN deve ter 10 ou 13 números.");
			}
			
			final String urlGet = "https://www.googleapis.com/books/v1/volumes?q=+isbn:"+isbn+"&key=AIzaSyAgg6itGrlT3cWjIMrprDV6_nduS_NvTwY";
			 HttpClient cliente = HttpClient.newHttpClient();
			 
			 HttpRequest request = HttpRequest.newBuilder()
					 .GET()
					 .uri(URI.create(urlGet))
					 .build();
			 
			HttpResponse<String> response = null;
						
			try {
				response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
			} catch (IOException e) {
				e.getMessage();
			} catch (InterruptedException e) {
				e.getMessage();
			} 
			
		  	Gson gson = new Gson();
		  	JsonObject obj = gson.fromJson(response.body(), JsonObject.class);
		 
		  	int verificaSeTemObjeto = obj.get("totalItems").getAsInt();
		  	
		  	if(verificaSeTemObjeto == 0) {
		  		throw new ExcecaoController("O isbn não foi encontrado.");
		  	}
		  	
		  	Map map = gson.fromJson(obj.get("items").getAsJsonArray().get(0), Map.class);
		  
		  	LivroModelo livro = new LivroModelo();
		  	
		  	livro.setTitulo((String)((Map) map.get("volumeInfo")).get("title"));
		  	livro.setAutor((String)((Map) map.get("volumeInfo")).get("authors").toString());
		  	livro.setIsbn(isbn);
		  	
		 	if ((((Map) map.get("volumeInfo")).containsKey("imageLinks"))){	
		 		Map<String, String> img = (Map<String, String>)((Map) map.get("volumeInfo")).get("imageLinks");
		 		livro.setImg(img.get("smallThumbnail"));
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
		 	
		 	//  try {
			//		  repository.CadastrarLivro(Livro);			
		 	//	}catch (DadosExcecao e){
			// 		  throw new (RegraNegocioExcecao(e.getMessage(), e);
		   //	} 
	}
		
		public void cadastrarLivro(String titulo, String autor, String editora, String isbn, String dataPublicacao, String descricao, String img) throws ExcecaoController{
			if(isbn.isBlank()){
				throw new ExcecaoController("O campo ISBN não pode ser vazio.");
			}
			
			if(!isbn.matches("^\\d+$")){
				throw new ExcecaoController("O campo ISBN não pode ter letras e nem espaços.");
			}
			
			if((isbn.length() != 10) && (isbn.length() != 13)) {
				throw new ExcecaoController("O campo ISBN deve ter 10 ou 13 números.");
			}
			
			if(titulo.isBlank()){
				throw new ExcecaoController("O campo título não pode ser vazio.");
			}
			
			if(descricao.isBlank()){
				throw new ExcecaoController("O campo título não pode ser vazio.");
			}
			
			if(img.isBlank()){
				throw new ExcecaoController("O campo título não pode ser vazio.");
			}
		
			if(autor.isBlank()){
				throw new ExcecaoController("O campo autor não pode ser vazio.");
			}
			
			if(!autor.matches("^[a-zA-Z,\\s]+$")){
				throw new ExcecaoController("O campo autor não pode ter números.");
			}
			
			if(editora.isBlank()){
				throw new ExcecaoController("O campo editora não pode ser vazio.");
			}
			
			if(dataPublicacao.isBlank()) {
				throw new ExcecaoController("O campo data da publicação não pode ser vazio.");
			}
			
			if(!dataPublicacao.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$") && (!dataPublicacao.matches("^(\\D*\\d\\D*){4}$"))){
				throw new ExcecaoController("O campo data da publicação está inválida. Verifique se esta no formato correto dd/mm/yyyy ou yyyy");
			}
			
			LivroModelo livro = new LivroModelo();
			
			livro.setIsbn(isbn);
			livro.setAutor(autor);
			livro.setTitulo(titulo);
			livro.setDataPublicacao(dataPublicacao);
			livro.setDescricao(descricao);
			livro.setEditora(editora);
			livro.setImg(img);
			
			//  try {
			//		  repository.CadastrarLivro(livro);			
		 	//	}catch (DadosExcecao e){
			// 		  throw new (RegraNegocioExcecao(e.getMessage(), e);
		   //	} 
		}
		
		public List<LivroModelo> BuscarTodosOsLivros(){
			//try {
					// repositorio.buscarTodosOsLivros;
					// return List<LivroModelo>;
			//}catch (DadosExcecao e){
					// throw new (RegraNegocioExcecao(e.getMessage(), e);
			//}
			
			return null;
		}
		
		public LivroModelo buscarLivroPorAutor(String autor) throws ExcecaoController {
			if(autor.isBlank()){
				throw new ExcecaoController("O campo autor não pode ser vazio.");
			}
			
			if(!autor.matches("^[a-zA-Z,\\s]+$")){
				throw new ExcecaoController("O campo autor não pode ter números.");
			}
			
			LivroModelo livro = new LivroModelo();
			
			//try {
					// livro = repositorio.buscarLivroPorAutor(autor);
					// return livro;
			//}catch (DadosExcecao e){
					// throw new (RegraNegocioExcecao(e.getMessage(), e);
			//}
			
			return null;
		}
		
		public LivroModelo buscarLivroPorISBN(String isbn) throws ExcecaoController {
			if(isbn.isBlank()){
				throw new ExcecaoController("O campo ISBN não pode ser vazio.");
			}
			
			if(!isbn.matches("^\\d+$")){
				throw new ExcecaoController("O campo ISBN não pode ter letras e nem espaços.");
			}
			
			if((isbn.length() != 10) && (isbn.length() != 13)) {
				throw new ExcecaoController("O campo ISBN deve ter 10 ou 13 números.");
			}
			
			LivroModelo livro = new LivroModelo();
			
			//try {
					// livro = repositorio.buscarLivroPorISBN(autor);
					// return livro;
			//}catch (DadosExcecao e){
					// throw new (RegraNegocioExcecao(e.getMessage(), e);
			//}
			
			return null;

		}
		
		public LivroModelo buscarLivroPorTitulo(String titulo) throws ExcecaoController {
			if(titulo.isBlank()){
				throw new ExcecaoController("O campo título não pode ser vazio.");
			}
			
			LivroModelo livro = new LivroModelo();
			
			//try {
					// livro = repositorio.buscarLivroPorTitulo(titulo);
					// return livro;
			//}catch (DadosExcecao e){
					// throw new (RegraNegocioExcecao(e.getMessage(), e);
			//}
			
			return null;
		}	
}		

