package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("Chimica", 28));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica", 18));

		lib.stampa();
		System.out.println(lib.toString());
		
		System.out.println("Voti pari a 25:");
		lib.stampa25();
		
		System.out.println(lib.getMarkFromClass("TdP"));
		System.out.println(lib.getMarkFromClass("tdp"));
		
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("TdP", 27));
		System.out.println(lib.toString());
		
		// MODIFICA
		Libretto newLib = new Libretto(lib.getVoti());
		newLib.alzaVoti();
		System.out.println("Nuovo Libretto");
		System.out.println(newLib.toString());
		System.out.println(lib.toString());

		// SORT #1 --> per nome
		Collections.sort(newLib.getVoti());
		System.out.println(newLib.toString());
		
		// SORT #2 --> per voti dec
		Collections.sort(newLib.getVoti(), new Comparator<Voto> () 
		{
			public int compare(Voto o1, Voto o2)
			{
				return -(o1.getVoto()-o2.getVoto());
			}
			
		});
		
		System.out.println(newLib.toString());

		newLib.remove(30);
		System.out.println(newLib.toString());
		
		
		
	}

}
