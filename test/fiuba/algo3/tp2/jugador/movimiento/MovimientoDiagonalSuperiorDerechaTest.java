package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoDiagonalSuperiorDerechaTest {

    @Test
    public void dadoUnMovimientoDiagonalSuperiorDerecha_LaPosicionRetrocedeUnaFilaYAvanzaUnaColumna () {
        Movimiento movimiento = new MovimientoDiagonalSuperiorDerecha();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(11,9);

        movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}