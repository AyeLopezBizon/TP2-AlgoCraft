package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.jugador.movimiento.Movimiento;
import fiuba.algo3.tp2.jugador.movimiento.MovimientoHaciaDerecha;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.jugador.Jugador;

import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.PosicionableVacio;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.terreno.casillero.Casillero;
import fiuba.algo3.tp2.terreno.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.terreno.casillero.CasilleroOcupadoException;
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

        // Al golpe 51 el se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
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

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        // Al golpe 51 el se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
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

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        // Al golpe 51 el se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
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

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        jugador.golpear(material);
    }

    @Test
    public void dadoUnJugador_DeberiaPoderPosicionarseEnUnCasilleroDeUnTerreno()
            throws CasilleroNoEncontradoException, CasilleroOcupadoException {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicion = new Posicion(1,1);
        Posicionable jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicion);

        Casillero casillero = terreno.obtenerCasillero(posicion);
        Posicionable objetoEnCasillero = casillero.obtenerPosicionable();

        assertEquals(jugador, objetoEnCasillero);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_DeberiaPoderMoverseALaDerecha()
            throws CasilleroNoEncontradoException, CasilleroOcupadoException {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,1);
        Posicion posicionFinal = new Posicion(2,1);
        Jugador jugador = new Jugador();
        Movimiento movimientoHaciaDerecha = new MovimientoHaciaDerecha();

        Casillero casilleroInicial = terreno.obtenerCasillero(posicionInicial);
        Casillero casilleroFinal = terreno.obtenerCasillero(posicionFinal);

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(movimientoHaciaDerecha, terreno);

        assertEquals(PosicionableVacio.class, casilleroInicial.obtenerPosicionable().getClass());
        assertEquals(jugador, casilleroFinal.obtenerPosicionable());
    }
/*
    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseALaDerecha()
            throws CasilleroNoEncontradoException, CasilleroOcupadoException {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();
        Movimiento movimientoHaciaDerecha = new MovimientoHaciaDerecha();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(movimientoHaciaDerecha, terreno);
    }
*/
}