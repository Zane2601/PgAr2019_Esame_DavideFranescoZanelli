package it.unibs.fp.esamearnaldo;

import java.util.ArrayList;

import it.unibs.fp.mylib.*;


public class Menu {
	
	private static final String SCELTE_4 = "puoi andare in una caverna(casella 5) o in un fiume(casella 6)";
	private static final String CASELLA_5 = "Entriamo in una caverna\n ";
	private static final String FINALE_PERDENTE = "Attraversi il bosco in fiamme e perdi tutta la tua vita.\n";
	private static final String FINALE_VITTORIOSO = "La strada ti porta alla via per la felicità: complimenti, ce l'hai fatta!\n";
	private static final String CASELLA_6 = "Attraversiamo il fiume a nuoto, schivando i piranha.";
	private static final String FINALE_ORSO = "Entri nella caverna: c'è un orso. Hai appena guadagnato un punto vita, ma l'orso ti mangia. Ti aspettavi un happy ending? Comunque hai vinto, sei arrivato alla fine.";
	private static final String CASELLA_4 = "Vediamo un pò cosa c'è in questo boschetto... (casella 4)\n";
	private static final String CASELLA_3 = "Ti sei accorto di aver sbagliato via poco fa? Ora sei nella casella 3\n";
	private static final String SCELTE_2 = "Da qui puoi andare alle caselle 0, 3, 4\n";
	private static final String CASELLA_2 = "Molto bene : un altro svincolo. Che facciamo?\n";
	private static final String SCELTE_1 = "Da qui puoi andare alle caselle 2, 3\n";
	private static final String CASELLA_1 = "Ora sei nella casella numero 1, sei arrivato ad uno svincolo congratulazioni!\n";
	private static final String TITOLO_MENU = "inizia la tua avventura";
	private static final String[] VOCI_MENU = {
			"Inizia partita"
	};
	
	private static final String FINE_AVVENTURA = "Grazie per aver giocato";
	
	Giocatore g = new Giocatore();
	
    //menu di inizio gioco in cui il giocatore può decidere di avviare la partita
	public void mostraMenu() {
		int scelta;
		int i=0;
		MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU);
		do {
			scelta=menu.scegli();
			switch(scelta) {
			case 1:
				String nome = InputDati.leggiStringa("Come ti chiami?\t"); //creazione di un giocatore
				g.setNome(nome);
				System.out.println("Qui non hai molte scelte: fai il prossimo passo!\n");
				i=InputDati.leggiIntero("schiaccia 1 per andare avanti\n");
				i=0;
				System.out.println(CASELLA_1);
				System.out.println(SCELTE_1);
				i=InputDati.leggiIntero("Fai la tua scelta "); //switch per scegliere la prossima casella dalla casella 1
				switch(i) {
				case 2:
					System.out.println("Ora sei nella casella 2\n");
					System.out.println(CASELLA_2);
					System.out.println(SCELTE_2);
					i=InputDati.leggiIntero("Fai la tua scelta\n ");   //switch per scegliere le vie dalla casella 2
					switch(i) {
					case 0:
						System.out.println("Dai ricominciamo è stato divertente");
						mostraMenu();
						break;
					case 3:
						System.out.println(CASELLA_3);
						System.out.println("Ok qui c'è una strada che potremmo seguire, porta alla casella 4");
						System.out.println(CASELLA_4);
						System.out.println("Eccoci qua: il boschetto. Ci sono una caverna e un fiume.");
						System.out.println(SCELTE_4);
						i=InputDati.leggiIntero("Quale scegli? 5 o 6? ");    //switch per scegliere dove andare dalla casella 4
						switch(i) {  
						case 5:
							System.out.println(CASELLA_5);
							System.out.println(FINALE_ORSO); //1° finale della casella 5
							break;
						case 6:
							System.out.println(CASELLA_6);
							System.out.println("Perdi 10 punti vita");
							g.setVita(g.getVita()-10);
							System.out.println("La tua vita attuale è = " + g.getVita());
							System.out.println("Hai attraversato il fiume: ci sono una strada(casella 7) e un bosco in fiamme(casella 0).\n");
							i=InputDati.leggiIntero("Dove scegli di andare? 7 o 0? ");  //switch per scegliere dove andare dalla casella 6
							switch(i) {
							case 7:
								System.out.println(FINALE_VITTORIOSO);  //finale vincente della 7° casella
								break;
							case 0:
								System.out.println(FINALE_PERDENTE);    //finale perdente della 7° casella
								System.out.println("<------------------->");
								System.out.println("Hai perso!");
								System.out.println("<------------------->");
							}
							
							break;
						}
						break;
					case 4:
						System.out.println(CASELLA_4);
						System.out.println("Eccoci qua: il boschetto. Ci sono una caverna e un fiume.");
						System.out.println(SCELTE_4);
						i=InputDati.leggiIntero("Quale scegli? 5 o 6? ");  //switch per le scelte dalla casella 4
						switch(i) {
						case 5:
							System.out.println(CASELLA_5);
							System.out.println(FINALE_ORSO);
							break;
						case 6:
							System.out.println(CASELLA_6);
							System.out.println("Perdi 10 punti vita");
							g.setVita(g.getVita()-10);
							System.out.println("La tua vita attuale è = " + g.getVita());
							System.out.println("Hai attraversato il fiume: ci sono una strada(casella 7) e un bosco in fiamme(casella 0).\n");
							i=InputDati.leggiIntero("Dove scegli di andare? 7 o 0? ");
							switch(i) {
							case 7:
								System.out.println(FINALE_VITTORIOSO);
								break;
							case 0:
								System.out.println(FINALE_PERDENTE);
								g.setVita(0);
								System.out.println("<------------------->");
								System.out.println("Hai perso!");
								System.out.println("<------------------->");
							}
							
							break;
						}
					}
					break;
				case 3:
					System.out.println("Ora sei nella casella 3");
					System.out.println(CASELLA_3);
					System.out.println("Ok qui c'è una strada che potremmo seguire, porta alla casella 4");
					System.out.println(CASELLA_4);
					System.out.println("Eccoci qua: il boschetto. Ci sono una caverna e un fiume.");
					System.out.println(SCELTE_4);
					i=InputDati.leggiIntero("Quale scegli? 5 o 6? ");
					switch(i) {
					case 5:
						System.out.println(CASELLA_5);
						System.out.println("Entri nella caverna: c'è un orso. Hai appena guadagnato un punto vita, ma l'orso ti mangia.\n Ti aspettavi un happy ending? Comunque hai vinto, sei arrivato alla fine.");
						break;
					case 6:
						System.out.println(CASELLA_6);
						System.out.println("Perdi 10 punti vita");
						g.setVita(g.getVita()-10);
						System.out.println("La tua vita attuale è = " + g.getVita());
						System.out.println("Hai attraversato il fiume: ci sono una strada(casella 7) e un bosco in fiamme(casella 0).\n");
						i=InputDati.leggiIntero("Dove scegli di andare? 7 o 0? ");
						switch(i) {
						case 7:
							System.out.println(FINALE_VITTORIOSO);
							break;
						case 0:
							System.out.println(FINALE_PERDENTE);
							System.out.println("<------------------->");
							System.out.println("Hai perso!");
							System.out.println("<------------------->");
						}
						
						break;
					}
					break;
				
				}
				
				
				break;
			
			}
			System.out.println(FINE_AVVENTURA);				 
			break;
		} while (scelta!=0);
		
	}
	
	/*public void mostraMenugioco() {
		int scelta1;
		
		MyMenu menu1 = new MyMenu();
		
		do {
			scelta1 = menu1.scegli();
			
			switch(scelta1) {
			case 1:
				break;
			}
			
		}while(scelta1!=0);
	}*/

}
