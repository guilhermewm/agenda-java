package model;

public class ValidaContato {
	
	private static ValidaContato vc = null;
	
	private ValidaContato(){
		
	}
	
	public static ValidaContato getInstance(){
		if(vc == null){
			vc = new ValidaContato();
		}
		return vc;
	}
	
	public static boolean validaNome(String nome) {
        return nome.contains(" ");
    }
    public static boolean validaTelefone(String telefone) {
        return (telefone.length() == 9);
    }
}
