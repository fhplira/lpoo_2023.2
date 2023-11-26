package controladores;

public class ExcecaoControlador extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ExcecaoControlador(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoControlador(String message) {
		super(message);
		
	}
}
