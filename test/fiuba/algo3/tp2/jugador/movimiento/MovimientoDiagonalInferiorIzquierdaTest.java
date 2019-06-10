package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoDiagonalInferiorIzquierdaTest {

    @Test
    public void dadoUnMovimientoDiagonalInferiorIzquierda_LaPosicionAvanzaUnaFilaYRetrocedeUnaColumna () {
        Movimiento movimiento = new MovimientoDiagonalInferiorIzquierda();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(9,9);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}