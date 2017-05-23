package model;


import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	private TreeMap<String, Contato> agenda;
	
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
	
	public TreeMap<String, Contato> getAgenda() {
		return agenda;
	}	
	
	public String addContato(Contato contato){
		if(ValidaContato.getInstance().validaNome(contato.getNome()) && ValidaContato.getInstance().validaTelefone(contato.getTelefone())){
			if(!agenda.containsKey(contato.getNome())){
				agenda.put(contato.getNome(), contato);
				return "Usu�rio cadastrado";
			}else{			
				return "N�o cadastrou o usu�rio";
			}
		}else{
			return "N�o cadastrou o usu�rio";
		}		
	}
	
	
	public String getTelefone(String nome){
		if(ValidaContato.getInstance().validaNome(nome)){
			if(agenda.containsKey(nome)){
				return agenda.get(nome).getTelefone();
			}else{
				return "Usu�rio n�o encontrado";
			}			
		}else{
			return "Usu�rio n�o encontrado";
		}
	}
	

	
}
