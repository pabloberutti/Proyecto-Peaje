package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Peaje {

	private ArrayList<Pasada> listaDeVehiculosQuePasaron;
	private HashSet<Vehiculo> vehiculosSinDuplicadosQuePasaron;
	
	public Peaje() {
		listaDeVehiculosQuePasaron = new ArrayList<>();
		vehiculosSinDuplicadosQuePasaron = new HashSet<>();
	}

	public Boolean registrarPasadaDeUnVehiculo(Pasada pasada) {
		Boolean pasoUnVehiculo = listaDeVehiculosQuePasaron.add(pasada);
		
		vehiculosSinDuplicadosQuePasaron.add(pasada.getVehiculo());
		
		return pasoUnVehiculo;
	}

	public ArrayList<Pasada> getListaDeVehiculosQuePasaron() {
		return this.listaDeVehiculosQuePasaron;
	}
	
	public HashSet<Vehiculo> getVehiculosSinDuplicadosQuePasaron() {
		return this.vehiculosSinDuplicadosQuePasaron;
	}
}
