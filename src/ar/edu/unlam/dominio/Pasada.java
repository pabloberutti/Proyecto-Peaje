package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Pasada {

	private String patente;
	private LocalDateTime fechaConHoraDeLaPasada;

	public Pasada(String patente, LocalDateTime fechaConHoraDeLaPasada) {
		this.patente = patente;
		this.fechaConHoraDeLaPasada = fechaConHoraDeLaPasada;
	}

}
