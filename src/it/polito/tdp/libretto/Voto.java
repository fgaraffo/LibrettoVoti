package it.polito.tdp.libretto;

import java.time.LocalDate;

// POJO: PLAIN OLD JAVA OBJECT

public class Voto implements Comparable <Voto> {

	private String nome;
	private int voto;
//	private LocalDate data;
	public Voto(String nome, int voto) {
		super();
		this.nome = nome;
		if (voto<18 || voto>32)
			throw new IllegalArgumentException("Valore non ammesso");
		this.voto = voto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		if (voto<18 || voto>34)
			throw new IllegalArgumentException("Valore non ammesso");
		this.voto = voto;
	}
	
	@Override
	public String toString() 
	{
		return "Voto [nome=" + nome + ", voto=" + voto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + voto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (voto != other.voto)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Voto v) {
		
		return this.nome.compareTo(v.getNome());
	}
		
}
