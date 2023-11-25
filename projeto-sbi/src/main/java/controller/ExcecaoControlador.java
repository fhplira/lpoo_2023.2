package controller;

public class ExcecaoControlador extends Exception{
	public ExcecaoControlador(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoControlador(String message) {
		super(message);
		
	}
}
