package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.jugador.Jugador;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaMaderaYReducirLaDurabilidadDelMaterialEn2()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Madera();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();
        BigDecimal durabilidadDelMaterialEsperada = durabilidadDelMaterialInicial.subtract(BigDecimal.valueOf(2));

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialEsperada, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaMadera5VecesYQueNoSeDestruyaElMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Madera();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();
        BigDecimal durabilidadDelMaterialEsperada = durabilidadDelMaterialInicial.subtract(BigDecimal.valueOf(10));

        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialEsperada, material.getDurabilidad());
    }

    @Test(expected = MaterialDestruidoNoSePuedeGolpearException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaMadera6VecesYDestruirElMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Madera();

        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);

        // Al sexto golpe se lanza Excepcion MaterialDestruidoNoSePuedeGolpearException.
        jugador.golpear(material);
    }

    @Test(expected = HerramientaDesgastadaNoSePuedeUsarException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearMaderas51VecesYDesgastarse ()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();

        for(int i = 0; i < 10; i++) {
            Material material = new Madera();
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
        }

        Material material = new Madera();
        jugador.golpear(material);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedraYNoReducirLaDurabilidadDelMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Piedra();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedra50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Piedra();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = HerramientaDesgastadaNoSePuedeUsarException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedra51VecesYDesgastarse()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Piedra();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        jugador.golpear(material);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetalYNoReducirLaDurabilidadDelMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Metal();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetal50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Metal();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = HerramientaDesgastadaNoSePuedeUsarException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetal51VecesYDesgastarse()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Metal();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        jugador.golpear(material);
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamanteYNoReducirLaDurabilidadDelMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Diamante();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamante50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Diamante();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = HerramientaDesgastadaNoSePuedeUsarException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamante51VecesYDesgastarse()
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        Jugador jugador = new Jugador();
        Material material = new Diamante();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        jugador.golpear(material);
    }
}