package org.esercizio.java;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//SCANNER
		
		Scanner s = new Scanner(System.in);
		int posti = 0;
		
		//CREAZIONE EVENTO
		
		System.out.println("Vuoi inserire un evento? 1-si 2-no");
		String scelta = s.nextLine();
		if (scelta.equals("1")) {
			
			// INSERIRE TITOLO EVENTO
			
			System.out.println("TITOLO EVENTO:");
			String titolo = s.nextLine();
			System.out.println("INSERISCI DATA: ( es. FORMATO dd/MM/yyyy )");
			String data = s.nextLine();
			try {
				// INSERIRE POSTI TOTALI DISPONIBILI
			
				System.out.println("INSERISCI IL NUM TOTALE DI POSTI DISPONIBILI");
				
				posti = s.nextInt();
				s.nextLine();

			} catch (Exception e) {
				System.out.println("INSERISCI UN NUM VALIDO!");

			}
			
			// EVENTO 
			Evento e = new Evento(titolo, data, posti);

			System.out.println("VUOI PRENOTARE? 1 - si 2-no");
			String sceltaP = s.nextLine();
			if (sceltaP.equals("1")) {
				System.out.println("QUANTI POSTI VUOI PRENOTARE?");
				int postiPrenotati = s.nextInt();
				s.nextLine();

				for (int i = 1; i <= postiPrenotati; i++) {

					try {
						e.aggiungiPosto();
					} catch (Exception e2) {
						
						// GESTIONE ERRORI
						System.out.println(e2.getMessage());
					}
				}
				// POSTI PRENOTATI E DISPONIBILI
				System.out.println("Posti prenotati: " + e.getNumeroPostiPrenotati());
				System.out.println("Posti disponibili: " + e.getNumeroPostiTotale());
				System.out.println("Vuoi disdire qualche posto? 1-si 2-no");
				String sceltaD = s.nextLine();
				if (sceltaD.equals("1")) {
					System.out.println("QUANTI POSTI VUOI DISDIRE?");
					int postiTolti = s.nextInt();
					s.nextLine();
					for (int i = 1; i <= postiTolti; i++) {
						try {
							e.togliPosto();
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}

					}
					
					System.out.println("Posti prenotati: " + e.getNumeroPostiPrenotati());
					System.out.println("Posti disponibili: " + e.getNumeroPostiTotale());
				} else {
					System.out.println("Posti prenotati: " + e.getNumeroPostiPrenotati());
					System.out.println("Posti disponibili: " + e.getNumeroPostiTotale());
				}

			} else {
				System.out.println("ARRIVEDERCI");
			}

		} else {
			System.out.println("ARRIVEDERCI AL PROSSIMO EVENTO!");
		}

		s.close();
	}
}
