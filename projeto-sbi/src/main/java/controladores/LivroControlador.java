package controladores;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dados.ExcecaoDados;
import dados.LivroDados;
import modelos.LivroModelo;


public class LivroControlador {
		
		private LivroDados dados = new LivroDados() ;
		private MetodosUteis metodo = new MetodosUteis();
		private String isbnSemPontos;
		
		public void cadastrarLivroPorISBN(String isbn) throws ExcecaoControlador{	
			
			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}
		
			
			if(isbn.matches(".*[.-].*")) {
				
						isbnSemPontos = metodo.removerPontos(isbn);
						
						if(!isbnSemPontos.matches("^\\d+$")){
							throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
						}
						
						if((isbnSemPontos.length() != 10) && (isbnSemPontos.length() != 13)) {
							throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
						}
				
			 }else {
				
						if(!isbn.matches("^\\d+$")){
							throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
						}
						
						if((isbn.length() != 10) && (isbn.length() != 13)) {
							throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
						}		
			 }
			
			
					 /*
				     *    try{
				     * 			if (dados.verificaSeExisteISBN(isbn)){
				     * 					throw new ExcecaoControlador("ISBN já cadastrado na base de dados.");
				     * 			}
				     *    }catch(ExcecaoDados e){
				 		  			throw new ExcecaoControlador(e.getMessage(), e);
			   				} 
				     */  
					
			
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
		 	
		 	livro.setTitulo((String)((Map) map.get("volumeInfo")).get("title"));
		 	livro.setAutor((String) ((Map) map.get("volumeInfo")).get("authors").toString());
		 	livro.setIsbn(isbn);
		 	
		 	
		    try {
				  dados.cadastrarLivro(livro);			
		 	}catch (ExcecaoDados e){
			 		  throw new ExcecaoControlador(e.getMessage(), e);
		   	} 
		    
	}
		
		
		public void cadastrarLivro(String isbn, String titulo, String autor, String editora, String dataPublicacao, String img, String descricao) throws ExcecaoControlador{
			
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
			
			  /*
			     *    try{
			     * 			if (dados.verificaSeExisteISBN(isbn)){
			     * 					throw new ExcecaoControlador("ISBN já cadastrado na base de dados.");
			     * 			}
			     *    }catch(ExcecaoDados e){
			 		  			throw new ExcecaoControlador(e.getMessage(), e);
		   				} 
			  */  
		
			    
			LivroModelo livro = new LivroModelo(isbn, titulo, autor, editora, dataPublicacao, descricao, img);
			
			 try {
				  dados.cadastrarLivro(livro);			
		 	}catch (ExcecaoDados e){
			 		  throw new ExcecaoControlador(e.getMessage(), e);
		   	} 
			 
		}
		
		
		public void controleDeExemplares(String isbn, int quantidade) throws ExcecaoControlador {
			
			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}
			
			if(isbn.matches(".*[.-].*")) {
				
					isbnSemPontos = metodo.removerPontos(isbn);
					
					if(!isbnSemPontos.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbnSemPontos.length() != 10) && (isbnSemPontos.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
			
			 } else {
			
					if(!isbn.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbn.length() != 10) && (isbn.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
			 }
			
			
			
			      
			    /*
			     *    try{
			     * 			if (dados.verificaSeExisteISBN(isbn)){
			     * 					throw new ExcecaoControlador("ISBN já cadastrado na base de dado.");
			     * 			}
			     *    }catch(ExcecaoDados e){
			 		  			throw new ExcecaoControlador(e.getMessage(), e);
		   				} 	    
			      
			     
					try {
						
						dados.controleDeExemplares(isbn, quantidade);
						
					}catch (ExcecaoDados e){
						 throw new ExcecaoControlador(e.getMessage(), e);
					}
					
				*/
		}
		
		
		public void atualizarLivro(String isbn,String titulo, String autor, String editora, String dataPublicacao, String descricao, String img) throws ExcecaoControlador {
			
			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}
			
			if(isbn.matches(".*[.-].*")) {
				
					isbnSemPontos = metodo.removerPontos(isbn);
					
					if(!isbnSemPontos.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbnSemPontos.length() != 10) && (isbnSemPontos.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
			
			}else {
			
					if(!isbn.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbn.length() != 10) && (isbn.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
			
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
					
					if(editora.isBlank()){
						throw new ExcecaoControlador("O campo título não pode ser vazio.");
					}
				
					
					if(descricao.isBlank()){
						throw new ExcecaoControlador("O campo título não pode ser vazio.");
					}
					
					if(img.isBlank()){
						throw new ExcecaoControlador("O campo título não pode ser vazio.");
					}
					
					if(!dataPublicacao.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$") && (!dataPublicacao.matches("^(\\D*\\d\\D*){4}$"))){
						throw new ExcecaoControlador("O campo data da publicação está inválida. Verifique se esta no formato correto dd/mm/yyyy ou yyyy");
					}
					
				
				LivroModelo livro = new LivroModelo();
				
				try {
					 dados.atualizarLivro(livro);
					
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
		
		
		
		public List<LivroModelo> buscarLivroPorAutor(String autor) throws ExcecaoControlador {
			if(autor.isBlank()){
				throw new ExcecaoControlador("O campo autor não pode ser vazio.");
			}
			
			if(!autor.matches("^[a-zA-Z,\\s]+$")){
				throw new ExcecaoControlador("O campo autor não pode ter números.");
			}
			
			
			try {
					return dados.buscarLivroPorAutor(autor);
	
			}catch (ExcecaoDados e){
				    throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
		
		
		
		public List<LivroModelo> buscarLivroPorISBN(String isbn) throws ExcecaoControlador {
			if(isbn.isBlank()){
				throw new ExcecaoControlador("O campo ISBN não pode ser vazio.");
			}
			
			if(isbn.matches(".*[.-].*")) {
				
					isbnSemPontos = metodo.removerPontos(isbn);
					
					if(!isbnSemPontos.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbnSemPontos.length() != 10) && (isbnSemPontos.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
		
			}else {
		
					if(!isbn.matches("^\\d+$")){
						throw new ExcecaoControlador("O campo ISBN não pode ter letras e nem espaços.");
					}
					
					if((isbn.length() != 10) && (isbn.length() != 13)) {
						throw new ExcecaoControlador("O campo ISBN deve ter 10 ou 13 números.");
					}
			
			}
				
					try {
							return dados.buscarLivroPorAutor(isbn);		
					}catch (ExcecaoDados e){
							 throw new ExcecaoControlador(e.getMessage(), e);
					}
			}
		
		
		
		public List<LivroModelo> buscarLivroPorTitulo(String titulo) throws ExcecaoControlador {
			
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

