package fiuba.algo3.tp2.modelo.jugador.movimiento;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class MovimientoHaciaIzquierdaTest {

    @Test
    public void dadoUnMovimientoHaciaIzquierda_LaPosicionRetrocedeUnaColumna () {
        Movimiento movimiento = new MovimientoHaciaIzquierda();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(9,10);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}