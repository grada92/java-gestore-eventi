package org.esercizio.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	// VARIABILI CONCERTO
	private final DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("HH:mm");
	private LocalTime ora;
	private final DecimalFormat formattatore1 = new DecimalFormat("#,##$");
	private BigDecimal prezzo;
	
	//COSTRUTTORE
	public Concerto(String titolo, String data, int numeroPostiTotale, String ora, String prezzo)
			throws Exception {
		super(titolo, data, numeroPostiTotale);
		setOra(ora);
	    setPrezzo(prezzo);
	}
	
	//FORMATTATORE 
	private LocalTime formatTime(String time) {
		 LocalTime timeLoc = LocalTime.parse(time,formattatore);
	        return timeLoc;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = formatTime(ora);
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String a) {
		this.prezzo = new BigDecimal(a);
	}

	@Override
	public String toString() {
		return "Concerto ora =" + ora + " prezzo " + formattatore1.format(prezzo) + " titolo " +getTitolo() +" data " + getData();
	}

	
	
	

}
