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
				// CREAZIONE EVENTO
				
				Concerto c = new Concerto("dkdk","20/03/2023",100,"22:14","2050.500");
				
				System.out.println(c);
				s.close();

			} else {
				System.out.println("ARRIVEDERCI");
				
			}

		} else {
			System.out.println("ARRIVEDERCI AL PROSSIMO EVENTO!");
		}

	}
}

/*
 

Stiamo lavorando a un programma che deve gestire eventi (ad esempio concerti,
conferenze, spettacoli,...)


MILESTONE 1

La consegna è di creare una classe Evento che abbia le seguenti proprietà:
● titolo
● data
● numero di posti in totale
● numero di posti prenotati
Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel
costruttore , tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo.
In caso contrario sollevare opportune eccezioni.
Aggiungere metodi getter e setter in modo che:
● titolo sia in lettura e in scrittura
● data sia in lettura e scrittura
● numero di posti totale sia solo in lettura
● numero di posti prenotati sia solo in lettura
Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
1. prenota : aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti
disponibili deve sollevare un’eccezione.
2. disdici : riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
prenotazioni deve sollevare un’eccezione.
3. l’override del metodo toString() in modo che venga restituita una stringa
contenente: data formattata - titolo
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.

MILESTONE 2

1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento
con tutti i parametri.
2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni
vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo
eventuali eccezioni.
3. Stampare a video il numero di posti prenotati e quelli disponibili
4. Chiedere all’utente se e quanti posti vuole disdire
5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo
eventuali eccezioni
6. Stampare a video il numero di posti prenotati e quelli disponibili

MILESTONE 3

Creare una classe Concerto che estende Evento, che ha anche gli attributi :
● ora: LocalTime
● prezzo: BigDecimal
Aggiungere questi attributi nel costruttore e implementarne getter e setter
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)
Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo:
data e ora formattata - titolo - prezzo formattato







 
 */
