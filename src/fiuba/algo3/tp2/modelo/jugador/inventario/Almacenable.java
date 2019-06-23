package fiuba.algo3.tp2.modelo.jugador.inventario;

import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public interface Almacenable {
	
	void equiparEn(Jugador jugador) throws EspacioVacioException;
	
	void almacenar(Inventario inventario, Integer numeroEspacioInventario);
	
	Integer obtenerNumeroEspacioInventario();

	void addObserver(Observer observer);
	
	void deleteObserver(Observer observer);

	void agregarAMesaDeTrabajo(MesaDeTrabajo mesaDeTrabajo, Posicion posicion) throws PosicionIncorrectaException, EspacioVacioException;
}
