package it.unibs.fp.esamearnaldo;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;





public class Lettore {
	
	
	XMLInputFactory xmlif = null;
	XMLStreamReader xmlr=null;
	

	private String mappa = "1) base.xml";
	
	
	
	public ArrayList<Casella> leggiXml() {
		
		ArrayList<Casella> listaCasella = new ArrayList<Casella>();
		
		String descrizione;
		int arrivo;
		
		
		int j = 0;
		
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader(mappa, new FileInputStream(mappa));
			
			xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader(mappa, new FileInputStream(mappa)); 
			 while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione 
				 switch (xmlr.getEventType()) { // switch sul tipo di evento
				 
				 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento 
					 //System.out.println("Start Read Doc " + mappa); 
					 break;
			     
				 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi 
			    	 //System.out.println("Tag " + xmlr.getLocalName());
					 Casella nuovaCasella = new Casella();
					 int op = 0; //variabile per salvare quante opzioni sono presenti in una casella
					 for(int i =0; i < xmlr.getAttributeCount(); i++){ 
						  if (xmlr.getLocalName().equals("cell")){
			    		 
			    			 switch (xmlr.getAttributeLocalName(i)) {
			    			 //dovrebbe salvare l'id trovato nell'xml come id di una casella specifica
			    			 case "id":
			    				 int idInt = Integer.parseInt(xmlr.getAttributeValue(i));
									nuovaCasella.setId(idInt);
			    				 break;
			    			 //dovrebbe ricavare dall'xml le differenti ozioni che si hanno da una casella
			    			 case "options":
			    				 int opInt = Integer.parseInt(xmlr.getAttributeValue(i));
			    				 op = opInt;
			    				 break;
			    			 
			    			 
			    			 }
			    			 listaCasella.add(nuovaCasella);
				    		 //System.out.println("nuova citta creata");
				    		 j++;
			    		}
					  }
					     if(xmlr.getLocalName().equals("description")) {
		    				 nuovaCasella.setDescrizione(xmlr.getElementText());    //dovrebbe salvare il testo della storia come descrizione della casella in modo che poi venga visualizzato durante il gioco
		    			 }
					     
					     
					   //ricavate le differenti opzioni permettere di aggiungere alla lista delle casella tutte le caselle ad essa collegate in modo che poi vengano visualizzate
                         if(xmlr.getLocalName().equals("option")) {     
			    				
                             for(int l = 0; l <= op; l++) {
		    			    	 arrivo = Integer.parseInt(xmlr.getAttributeValue(l));
		    				     ArrayList<Integer> destinazioni = new ArrayList<Integer>();
		    				     destinazioni.add(arrivo);
		    				     nuovaCasella.setDestinazione(destinazioni);
		    			      }
		    			 }
					     
		    			 
					 
					 
			    	 
			    	 
			         
			         break;
			     
				 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso 
			    	 //System.out.println("END-Tag " + xmlr.getLocalName()); 
			    	 break;
			     
				 case XMLStreamConstants.COMMENT:
			         //System.out.println("// commento " + xmlr.getText()); 
			         break; // commento: ne stampa il contenuto
			     
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo 
			    	 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
			         //System.out.println("-> " + xmlr.getText()); 
			    	 break;
			    	 }
			    
				 xmlr.next();
			    
			     }
			 
			 } 
		 catch (Exception e) {
			 //System.out.println("Errore nell'inizializzazione del reader:");
			 //System.out.println(e.getMessage()); 
			 }
		 
		 //System.out.println(listaCitta.size());
		 //System.out.println("\n\n\n");		 
		 
		 
		 
		 return listaCasella;
	}
	
	
	//metodo che mi consentiva di vedere se le differenti caselli venivano salvate all'interno dell'array
	public void stampalista(ArrayList<Casella> caselle){
		for(int j=0; j<caselle.size(); j++) {
			System.out.println("" + caselle.get(j).getId());
			
		}
	}

}
