package controller;

import java.util.ArrayList;

import model.Leitor;

public class LeitorController {
	private ArrayList<Leitor> leitores = new ArrayList<Leitor>();
	
	
	public Leitor buscarLeitor(String cpf) {
		if(cpf != null && !cpf.equals("00000000000")) {
			for(Leitor leitor : leitores) {
				if(leitor.getCpf().equals(cpf)){
					return leitor;
				}
			}
		}
		return null;
		//tratar fluxo de excessão caso o leitor não seja encontrado;
	}

}