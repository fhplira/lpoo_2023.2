package controller;

import java.util.ArrayList;

import model.LeitorModelo;

public class LeitorControlador {
	private ArrayList<LeitorModelo> leitores = new ArrayList<LeitorModelo>();
	
	
	public LeitorModelo buscarLeitor(String cpf) {
		if(cpf != null && !cpf.equals("00000000000")) {
			for(LeitorModelo leitor : leitores) {
				if(leitor.getCpf().equals(cpf)){
					return leitor;
				}
			}
		}
		return null;
		//tratar fluxo de excessão caso o leitor não seja encontrado;
	}

}