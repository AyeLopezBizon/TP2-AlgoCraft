package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoDiagonalInferiorDerechaTest {

    @Test
    public void dadoUnMovimientoDiagonalInferiorDerecha_LaPosicionRetrocedeUnaFilaYAvanzaUnaColumna () {
        Movimiento movimiento = new MovimientoDiagonalInferiorDerecha();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(11,9);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}