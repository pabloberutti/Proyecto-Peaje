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
		return pasoUnVehiculo;
	}

	public ArrayList<Pasada> getListaDeVehiculosQuePasaron() {
		return this.listaDeVehiculosQuePasaron;
	}

	public Boolean registrarVehiculoPorSiNuncaPaso(Vehiculo vehiculo) {
		Boolean seRegistro = vehiculosSinDuplicadosQuePasaron.add(vehiculo);
		return seRegistro;
	}
	
	public HashSet<Vehiculo> getVehiculosSinDuplicadosQuePasaron() {
		return this.vehiculosSinDuplicadosQuePasaron;
	}
}
