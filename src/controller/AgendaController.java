package controller;

import model.Agenda;
import model.Contato;

public class AgendaController {
	private static AgendaController ac = null;
	
	private AgendaController(){		
	}
	
	public static AgendaController getInstance(){
		if(ac == null){
			ac = new AgendaController();
		}
		return ac;
	}
	
	public Contato criaContato(String nome, String telefone){
		return new Contato(nome, telefone);
	}
	
	public String adicionaContato(String nome, String telefone){
		if(Agenda.getInstance().addContato(criaContato(nome, telefone))){
			return "Cadastrado com sucesso";
		}else{
			return "Não cadastrado";
		}
	}
}
