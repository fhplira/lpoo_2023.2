package controller;

public class ExcecaoController extends Exception{
	public ExcecaoController(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoController(String message) {
		super(message);
		
	}
}
