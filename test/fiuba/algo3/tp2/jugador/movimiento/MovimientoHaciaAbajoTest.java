package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoHaciaAbajoTest {

    @Test
    public void dadoUnMovimientoHaciaAbajo_LaPosicionAvanzaUnaFila () {
        Movimiento movimiento = new MovimientoHaciaAbajo();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(10,9);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}