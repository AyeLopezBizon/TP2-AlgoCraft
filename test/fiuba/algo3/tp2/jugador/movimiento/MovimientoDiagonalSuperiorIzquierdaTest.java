package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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