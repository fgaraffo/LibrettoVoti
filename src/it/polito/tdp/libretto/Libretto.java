package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Libretto {

	private List <Voto> voti;
	
	public Libretto ()
	{
		this.voti = new ArrayList<>(); // il tipo è sottointeso
	}
	
	public Libretto (List <Voto> voti)
	{
//		#1	
//		this.voti = voti; // ERRATO, VUOI "DEEP COPY"
//		#2	
//		this.voti = new ArrayList <Voto> (voti); // ERRATO
//		#3	EQUIVALE ALLA #2
//		this.voti = new ArrayList<Voto>();
//		for (Voto v : voti)
//		{
//			this.voti.add(v);
//		}
//		#4 - CORRETTO	
		this.voti = new ArrayList<Voto>();
		for (Voto v : voti)
		{
			this.voti.add(new Voto(v.getNome(), v.getVoto()));
		}
// magari in un altro caso vorresti che le due liste puntassero allo  stesso oggetto, non qui	
	}
	
	public void add(Voto v)
	{
		if (this.voti.contains(v))
		{
			System.out.println("Esiste già");
			return;
		}	
		for (Voto voto : this.voti)
		{
			if (voto.getNome().equals(v.getNome()))
			{
				System.out.println("Trovato lo stesso esame (aggiorno il voto)");
				voto.setVoto(v.getVoto());
				return;
			}
		}
		
			this.voti.add(v);
	}
	
	public void alzaVoti ()
	{
		for (Voto v : this.voti)
		{
			if (v.getVoto()>24)
				v.setVoto(v.getVoto()+2);
			else if (v.getVoto() >= 18)
				v.setVoto(v.getVoto()+1);
		}
	}
		
	public void stampa()
	{
		System.out.println("Ci sono "+voti.size()+" voti");
		for (Voto v : this.voti)
			System.out.println(v);
	}

	public void stampa25() 
	{
		for (Voto v : this.voti)
		{
			if (v.getVoto()==25)
				System.out.println(v);
		}
		
	}

	public List <Voto> getVoti ()
	{
		return this.voti;
	}
	
	@Override
	public String toString() { // alternativo al metodo stampa() sopra
		StringBuilder sb = new StringBuilder ();
		sb.append("Ci sono "+voti.size()+" voti\n");
		for (Voto v : this.voti)
		{
			sb.append(v); // chiama il toString() di voto
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getMarkFromClass (String nomeCorso)
	{
		for (Voto v : this.voti)
		{
			if (v.getNome().toLowerCase().equals(nomeCorso.toLowerCase()))
			{
				return String.valueOf(v.getVoto());
			}
		}
		return "Non presente";
	}

	public void remove (int i) 
	{
		for (Iterator <Voto> iter = this.voti.iterator() ; iter.hasNext(); )
		{
		    Voto v = iter.next();
		    if (v.getVoto()<i)
		    {
		        iter.remove();
		    }
		}
	}
	
}
