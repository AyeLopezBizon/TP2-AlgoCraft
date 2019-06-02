package fiuba.algo3.tp2.integracion.entrega1;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.math.BigDecimal;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.jugador.Jugador;

=======
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.jugador.Jugador;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

>>>>>>> refs/remotes/origin/develop
public class JugadorTest {

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaConDurabilidad100() {
        Jugador jugador = new Jugador();
        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(100);
        assertEquals(jugador.getDurabilidadDelHachaDeMadera(),durabilidadDeUnHachaDeMadera);
    }

    @Test
<<<<<<< HEAD
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaConDurabilidad98LuegoDeGolpearUnMaterialDeMadera() {
=======
    public void cuandoSeCreaUnJugador_DeberiaPoderGolpearUnMaterialDeMaderaConSuHachaDeMaderaYQueSuDurabilidadBajeA98() {
>>>>>>> refs/remotes/origin/develop
        Jugador jugador = new Jugador();
        Material madera = new Madera();
        jugador.golpearConHachaDeMadera(madera);
        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        assertEquals(jugador.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
    }
}