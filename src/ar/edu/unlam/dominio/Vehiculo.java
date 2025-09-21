package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vehiculo {

	private String patente;

	public Vehiculo(String patente) {
		this.patente = patente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}
	
}
