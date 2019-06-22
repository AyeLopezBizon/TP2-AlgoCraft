package fiuba.algo3.tp2.modelo.jugador.inventario;

import java.util.Observer;

import fiuba.algo3.tp2.modelo.jugador.Jugador;

public interface Almacenable {
	
	void equiparEn(Jugador jugador) throws EspacioVacioException;
	
	void almacenar(Integer numeroEspacioInventario);
	
	Integer obtenerNumeroEspacioInventario();

	void addObserver(Observer observer);
	
	void deleteObserver(Observer observer);
}
