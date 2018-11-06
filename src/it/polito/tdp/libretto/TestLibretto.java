package it.polito.tdp.libretto;

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
		
		Libretto newLib = new Libretto(lib.getVoti());
		newLib.alzaVoti();
		System.out.println("Nuovo Libretto");
		System.out.println(newLib.toString());
		
		System.out.println(lib.toString());

			
	}

}
