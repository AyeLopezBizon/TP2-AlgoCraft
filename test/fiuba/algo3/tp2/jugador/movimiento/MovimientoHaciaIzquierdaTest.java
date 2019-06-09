package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoHaciaIzquierdaTest {

    @Test
    public void dadoUnMovimientoHaciaIzquierda_LaPosicionRetrocedeUnaColumna () {
        Movimiento movimiento = new MovimientoHaciaIzquierda();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(9,10);

        movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}