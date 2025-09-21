package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Pasada {

	private Vehiculo vehiculo;
	private LocalDateTime fechaConHoraDeLaPasada;

	public Pasada(Vehiculo vehiculo, LocalDateTime fechaConHoraDeLaPasada) {
		this.vehiculo = vehiculo;
		this.fechaConHoraDeLaPasada = fechaConHoraDeLaPasada;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
}
