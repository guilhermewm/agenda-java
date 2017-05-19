package model;


import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	private Map<String, Contato> agenda;
	
	private static Agenda ag = null;
	
	private Agenda(){
		this.agenda = new TreeMap<String, Contato>();
	}
	
	public static Agenda getInstance(){
		if(ag == null){
			ag = new Agenda();
		}
		return ag;
	}
	
	public Map<String, Contato> getAgenda() {
		return agenda;
	}	
	
	public boolean addContato(Contato contato){
		if(ValidaContato.getInstance().validaNome(contato.getNome()) && ValidaContato.getInstance().validaTelefone(contato.getTelefone())){
			if(!agenda.containsKey(contato.getNome())){
				agenda.put(contato.getNome(), contato);
				return true;
			}else{			
				return false;
			}
		}else{
			return false;
		}		
	}
	
	public Contato getTelefone(String nome){
		if(ValidaContato.getInstance().validaNome(nome)){
			return agenda.get(nome);
		}else{
			return null;
		}
	}
	

	
}
