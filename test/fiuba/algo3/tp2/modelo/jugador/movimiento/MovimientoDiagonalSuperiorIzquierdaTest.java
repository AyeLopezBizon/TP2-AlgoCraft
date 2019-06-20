package fiuba.algo3.tp2.modelo.jugador.movimiento;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class MovimientoDiagonalSuperiorIzquierdaTest {

    @Test
    public void dadoUnMovimientoDiagonalSuperiorIzquierda_LaPosicionAvanzaUnaFilaYRetrocedeUnaColumna () {
        Movimiento movimiento = new MovimientoDiagonalSuperiorIzquierda();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(9,11);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}