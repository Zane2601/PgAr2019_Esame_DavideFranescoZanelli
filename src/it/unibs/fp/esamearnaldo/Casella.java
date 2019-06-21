package it.unibs.fp.esamearnaldo;

import java.util.ArrayList;

public class Casella {
	
	private int id;
	private String tipo;
	private String effetto;
	private String descrizione;
    private ArrayList<Integer> destinazione = new ArrayList<Integer>();
    
    
    //costruttore che mi permetteva di costruire una casella con tutte le sue caratteristiche
    public Casella(int _id, String _tipo, String _effetto, String _descrizione, ArrayList<Integer> _destinazione) {
		this.id = _id;
		this.tipo = _tipo;
		this.effetto = _effetto;
		this.descrizione = _descrizione;
		this.destinazione = _destinazione;
	}
    
    
    //costruttore vuoto per richiamare la classe in altri classi
	public Casella() {
    	
    }
	
	///////////////////////////////////////////////////
	
	//getters e setters per modificare i diversi parametri delle caselle
    
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEffetto() {
		return effetto;
	}
	
	public ArrayList<Integer> getDestinazione() {
		return destinazione;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEffetto(String effetto) {
		this.effetto = effetto;
	}

	public void setDestinazione(ArrayList<Integer> destinazioni) {
		this.destinazione = destinazioni;
	}

	
	
	
    
	

}
