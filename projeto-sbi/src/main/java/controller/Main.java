package controller;

public class Main {
	public static void main(String[] args) throws ExcecaoController {
		LivroControlador livro = new LivroControlador();
		System.out.println(livro.cadastrarLivroPorISBN("9788535236996"));
		
		String autor = "aaa,bbb,cc9";
		System.out.println(autor.matches("^[a-zA-Z,\\s]+$"));
	}
}
