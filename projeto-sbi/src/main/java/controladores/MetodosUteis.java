package controladores;

public class MetodosUteis {
	
	public String removerPontos(String string) {
		String novaString = null;
		
		novaString.replaceAll("[^0-9]", "");
		
		return novaString;
	}
}
