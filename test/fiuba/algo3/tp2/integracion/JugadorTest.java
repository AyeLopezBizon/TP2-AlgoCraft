package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.jugador.Jugador;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaConDurabilidad100() {
        Jugador jugador = new Jugador();
        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(100);
        assertEquals(jugador.getDurabilidadDelHachaDeMadera(),durabilidadDeUnHachaDeMadera);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaGolpearConSuHachaDeMaderaUnaMaderaYQueLaDurabilidadDelHachaBajeA98YLaDeLaMaderaA8() {
        Jugador jugador = new Jugador();
        Material madera = new Madera();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDeLaMadera = new BigDecimal(8);

        jugador.golpearConHachaDeMadera(madera);

        assertEquals(jugador.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(madera.getDurabilidad(), durabilidadDeLaMadera);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaGolpearConSuHachaDeMaderaUnaPiedraYQueLaDurabilidadDelHachaBajeA98YLaDeLaPiedraNoBaje() {
        Jugador jugador = new Jugador();
        Material piedra = new Piedra();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDeLaPiedra = new BigDecimal(30);

        jugador.golpearConHachaDeMadera(piedra);

        assertEquals(jugador.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(piedra.getDurabilidad(), durabilidadDeLaPiedra);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaGolpearConSuHachaDeMaderaUnMetalYQueLaDurabilidadDelHachaBajeA98YLaDelMetalNoBaje() {
        Jugador jugador = new Jugador();
        Material metal = new Metal();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDelMetal = new BigDecimal(50);

        jugador.golpearConHachaDeMadera(metal);

        assertEquals(jugador.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(metal.getDurabilidad(), durabilidadDelMetal);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaGolpearConSuHachaDeMaderaUnDiamanteYQueLaDurabilidadDelHachaBajeA98YLaDelDiamanteNoBaje() {
        Jugador jugador = new Jugador();
        Material diamante = new Diamante();

        BigDecimal durabilidadDeUnHachaDeMadera = new BigDecimal(98);
        BigDecimal durabilidadDelDiamante = new BigDecimal(100);

        jugador.golpearConHachaDeMadera(diamante);

        assertEquals(jugador.getDurabilidadDelHachaDeMadera(), durabilidadDeUnHachaDeMadera);
        assertEquals(diamante.getDurabilidad(), durabilidadDelDiamante);
    }
}