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

import model.Livro;

public class LivroController {
		
		public String cadastrarLivroPorISBN(String isbn){
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(response.body());
		  	Gson gson = new Gson();
		  	JsonObject obj = gson.fromJson(response.body(), JsonObject.class);
		 
		  	Map map = gson.fromJson(obj.get("items").getAsJsonArray().get(0), Map.class);
		  
		 	//System.out.println((((Map) map.get("volumeInfo")).get("imageLinks")));
		 
		 	Livro livro = new Livro();
		 	livro.setTitulo((String)((Map) map.get("volumeInfo")).get("title"));
		 	livro.setDataPublicacao((String)((Map) map.get("volumeInfo")).get("publishedDate").toString());
		 	livro.setAutor((String)((Map) map.get("volumeInfo")).get("authors").toString());
		 	livro.setDescricao((String)((Map) map.get("volumeInfo")).get("description").toString());
		 	livro.setIsbn(isbn);
		 	
		 	return livro.toString();
		 
	}
		
		public Livro cadastrarLivro(String titulo, String autor, String editora, String isbn, String dataPublicacao) {
			// Fazer verificação dos dados
			Livro livro = new Livro();
			livro.setTitulo(titulo);
		 	livro.setDataPublicacao(dataPublicacao);
		 	livro.setAutor(autor);
		 	livro.setIsbn(isbn);
			
			return livro;
		}
		
		public List<Livro> BuscarTodosLivros(){
			//return Dao.buscarTodosLivros;
			return null;
		}
		
		public Livro buscarLivroPorAutor(String autor) {
			//return Dao.buscarLivroPorAutor;
			return null;
		}
		
		public Livro buscarLivroPorISBN(String isbn) {
			//return Dao.buscarLivroPorAutor;
			return null;
		}
		
		public Livro buscarLivroPorTitulo(String titulo) {
			//return Dao.buscarLivroPorTitulo;
			return null;
		}
		
		
	
		
}
