package fiuba.algo3.tp2.integracion.entrega1;

import fiuba.algo3.tp2.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {

    @Test
    public void unJugador_CuandoSeCrea_DeberiaTenerUnHachaDeMadera() {
        Jugador jugador = new Jugador();
        float durabilidadIncialDeUnHachaDeMadera = 100;
        assertTrue(jugador.getDurabilidadDelHachaDeMadera() == durabilidadIncialDeUnHachaDeMadera);
    }
}
