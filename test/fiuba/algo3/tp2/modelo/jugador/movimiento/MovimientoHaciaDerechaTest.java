package fiuba.algo3.tp2.modelo.jugador.movimiento;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class MovimientoHaciaDerechaTest {

    @Test
    public void dadoUnMovimientoHaciaDerecha_LaPosicionAvanzaUnaColumna () {
        Movimiento movimiento = new MovimientoHaciaDerecha();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(11,10);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}