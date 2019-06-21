package it.unibs.fp.esamearnaldo;

public class Giocatore {
	
	private String nome;
	private int vita = 100;
	//private Casella posizione;
	
	//costruttore con tutte le istanze della classe
	public Giocatore(String nome, int vita) {
		this.nome = nome;
		this.vita = vita;
		
	}
	
	
	//costruttore vuoto per richiamare la classe in altre classi
	public Giocatore() {
		
	}
////////////////////////////////////////////////////

	
	//getters e setters per modificare i parametri del giocatore durante la giocata
	public String getNome() {
		return nome;
	}


	public int getVita() {
		return vita;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setVita(int vita) {
		this.vita = vita;
	}
	
	

}
