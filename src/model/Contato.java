package model;

public class Contato {
	private String nome;
	private String telefone;
		
	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}	
	
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + "]";
	}
	
	
}
