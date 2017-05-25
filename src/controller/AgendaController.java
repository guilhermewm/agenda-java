package controller;

import java.io.FileNotFoundException;
import java.util.TreeMap;

import dados.GerenciaArquivos;
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
		return Agenda.getInstance().addContato(criaContato(nome, telefone));		
	}
	
	public String getTelefone(String nome){
		return Agenda.getInstance().getTelefone(nome);
	}
	
	public TreeMap<String, Contato> getListaContatos(){
		return Agenda.getInstance().getAgenda();
	}

	public void leArquivo() throws FileNotFoundException {
		GerenciaArquivos.getInstance().lerArquivo();		
	}
}
