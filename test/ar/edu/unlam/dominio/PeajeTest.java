package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

//	Una empresa de peajes registra cada paso de vehículos, lo que resulta en una colección con múltiples entradas duplicadas (un vehiculo puede pasar varias veces).
//	Es necesario poder registrar la pasada de un vehiculo (vehiculo y fecha con hora), obtener un listado de todas las pasadas realizadas (todos los vehiculos)
//	y obtener un listado de vehiculos (solo vehiculos) sin duplicados. Para identificar a cada vehiculo debemos usar la patente

public class PeajeTest {
	private Peaje peaje;
	
	@Before
	public void inicializacion() {
		peaje = new Peaje();
	}
	
	@Test
	public void dadoQueHayQueRegistrarLaPasadaDeUnVehiculoPorElTelepaseCuandoUnVehiculoPaseHayQueRegistrarleLaPatenteYLaFechaYHoraEnLaQuePaso() {
		String patente = "AB123CD";
		Vehiculo vehiculoGenerico = new Vehiculo(patente);
		LocalDateTime fechaConHoraActual = LocalDateTime.of(2025,9,21,17,11,0);
		
		Pasada pasada1 = new Pasada(vehiculoGenerico, fechaConHoraActual);
		Boolean pasoUnVehiculo = peaje.registrarPasadaDeUnVehiculo(pasada1);
		
		assertTrue(pasoUnVehiculo);
		assertFalse(peaje.getListaDeVehiculosQuePasaron().isEmpty());
	}

	@Test
	public void dadoQueUnMismoVehiculoPuedePasarRepetidasVecesCuandoPaseTresVecesSeTienenQueRegistrarTresPasadas() {
		// DATOS DEL VEHICULO
		String patente = "AB123CD";
		Vehiculo vehiculoGenerico = new Vehiculo(patente);
		
		// PASADA 1
		LocalDateTime fechaConHoraPasada1 = LocalDateTime.of(2025,9,21,17,11,0);
		Pasada pasada1 = new Pasada(vehiculoGenerico, fechaConHoraPasada1);
		Boolean pasoUnVehiculo1 = peaje.registrarPasadaDeUnVehiculo(pasada1);
		// PASADA 2
		LocalDateTime fechaConHoraPasada2 = LocalDateTime.of(2025,9,21,19,45,32);
		Pasada pasada2 = new Pasada(vehiculoGenerico, fechaConHoraPasada2);
		Boolean pasoUnVehiculo2 = peaje.registrarPasadaDeUnVehiculo(pasada2);
		// PASADA 3
		LocalDateTime fechaConHoraPasada3 = LocalDateTime.of(2025,9,22,8,5,23);
		Pasada pasada3 = new Pasada(vehiculoGenerico, fechaConHoraPasada3);
		Boolean pasoUnVehiculo3 = peaje.registrarPasadaDeUnVehiculo(pasada3);
		
		assertTrue(pasoUnVehiculo1);
		assertTrue(pasoUnVehiculo2);
		assertTrue(pasoUnVehiculo3);
		assertEquals(3, peaje.getListaDeVehiculosQuePasaron().size());
	}
	
	@Test
	public void dadoQueHayQueListarTodosLosVehiculosCuandoPasenPorElTelepaseHayQueListarlosEnUnHashSetParaQueNoHayaRepetidos() {
		// DATOS DE TRES VEHICULOS
		String patente1 = "AB123CD";
		Vehiculo vehiculoGenerico1 = new Vehiculo(patente1);
		String patente2 = "WX563YZ";
		Vehiculo vehiculoGenerico2 = new Vehiculo(patente2);
		String patente3 = "CF222AL";
		Vehiculo vehiculoGenerico3 = new Vehiculo(patente3);
		
		// PASADA 1
		LocalDateTime fechaConHoraPasada1 = LocalDateTime.of(2025,9,21,17,11,0);
		Pasada pasada1 = new Pasada(vehiculoGenerico1, fechaConHoraPasada1);
		peaje.registrarPasadaDeUnVehiculo(pasada1);
		// PASADA 2
		LocalDateTime fechaConHoraPasada2 = LocalDateTime.of(2025,9,21,19,47,32);
		Pasada pasada2 = new Pasada(vehiculoGenerico2, fechaConHoraPasada2);
		peaje.registrarPasadaDeUnVehiculo(pasada2);
		// PASADA 3
		LocalDateTime fechaConHoraPasada3 = LocalDateTime.of(2025,9,22,8,5,23);
		Pasada pasada3 = new Pasada(vehiculoGenerico1, fechaConHoraPasada3);
		peaje.registrarPasadaDeUnVehiculo(pasada3);
		// PASADA 4
		LocalDateTime fechaConHoraPasada4 = LocalDateTime.of(2025,9,22,8,11,42);
		Pasada pasada4 = new Pasada(vehiculoGenerico3, fechaConHoraPasada4);
		peaje.registrarPasadaDeUnVehiculo(pasada4);
		// PASADA 5
		LocalDateTime fechaConHoraPasada5 = LocalDateTime.of(2025,9,22,8,12,3);
		Pasada pasada5 = new Pasada(vehiculoGenerico2, fechaConHoraPasada5);
		peaje.registrarPasadaDeUnVehiculo(pasada5);
		
		assertEquals(3, peaje.getVehiculosSinDuplicadosQuePasaron().size());
	}
}