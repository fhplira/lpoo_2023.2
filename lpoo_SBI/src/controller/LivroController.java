package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Livro;

public class LivroController {
		
		public Livro cadastrarLivroPorISBN(String isbn){
			
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
			
		  	Gson gson = new Gson();
		  	JsonObject obj = gson.fromJson(response.body(), JsonObject.class);
		 
		  	Map map = gson.fromJson(obj.get("items").getAsJsonArray().get(0), Map.class);
		  
		  	String titulo = (String)((Map) map.get("volumeInfo")).get("title");
		 	String autor = (String)((Map) map.get("volumeInfo")).get("authors").toString(); 
		 	String data = (String)((Map) map.get("volumeInfo")).get("publishedDate").toString(); 
		 	//System.out.println((((Map) map.get("volumeInfo")).get("imageLinks")));
		 
		 	Livro livro = new Livro();
		 	livro.setTitulo(titulo);
		 	livro.setDataPublicacao(data);
		 	livro.setAutor(autor);
		 	livro.setIsbn(isbn);
		 	
		 	return livro;
		 
	}
}
