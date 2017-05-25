package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

import controller.AgendaController;
import model.Agenda;
import model.Contato;

public class GerenciaArquivos {
	private static GerenciaArquivos ga = null;
	
	private GerenciaArquivos(){		
	}
	
	public static GerenciaArquivos getInstance(){
		if(ga == null){
			ga = new GerenciaArquivos();
		}
		return ga;
	}
	
	
	public TreeMap<String,Contato> lerArquivo(){
		Scanner scanner = null;
		TreeMap<String,Contato> contatos = new TreeMap<>();
		try {
			FileReader fileReader = new FileReader("Arquivos\\contatos.txt");
			scanner = new Scanner(fileReader).useDelimiter("\\s*#####\\s*");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			if (scanner.hasNext()) {
				String nome = scanner.next();
				String telefone = scanner.next();
				contatos.put(nome, new Contato(nome, telefone));
			} else {
				break;
			}
		}
		return contatos;
	}
	
	public boolean salvaDadosEmArquivo(Contato contato) {
		PrintWriter gravar = null;
		try {
			FileWriter fileReader = new FileWriter("Arquivos\\contatos.txt", true);
			gravar = new PrintWriter(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(contato.getNome());
		stringBuilder.append("#####");
		
		stringBuilder.append(contato.getTelefone());
		stringBuilder.append("#####");
		
		gravar.println(stringBuilder);
		gravar.close();
		return false;
	}
}
