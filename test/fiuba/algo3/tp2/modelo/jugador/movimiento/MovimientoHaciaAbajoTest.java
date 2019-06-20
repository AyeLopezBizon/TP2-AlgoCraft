package fiuba.algo3.tp2.modelo.jugador.movimiento;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

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