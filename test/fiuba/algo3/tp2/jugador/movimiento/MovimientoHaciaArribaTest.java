package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovimientoHaciaArribaTest {

    @Test
    public void dadoUnMovimientoHaciaArriba_LaPosicionAvanzaUnaFila () {
        Movimiento movimiento = new MovimientoHaciaArriba();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(10,11);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}