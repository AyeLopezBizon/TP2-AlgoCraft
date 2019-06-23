package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.NoHayHerramientaEquipadaException;
import fiuba.algo3.tp2.modelo.jugador.movimiento.Movimiento;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalInferiorDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalInferiorIzquierda;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalSuperiorDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoDiagonalSuperiorIzquierda;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaAbajo;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaArriba;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaDerecha;
import fiuba.algo3.tp2.modelo.jugador.movimiento.MovimientoHaciaIzquierda;
import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

public class JugadorTest {

    /*************************************************
     * JUGADOR CON HACHA DE MADERA GOLPEA UNA MADERA *
     *************************************************/
	
    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaMaderaYReducirLaDurabilidadDelMaterialEn2()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Madera();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();
        BigDecimal durabilidadDelMaterialEsperada = durabilidadDelMaterialInicial.subtract(BigDecimal.valueOf(2));

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialEsperada, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaMadera5VecesYQueNoSeDestruyaElMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
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
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Madera();

        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);
        jugador.golpear(material);

        // Al sexto golpe se lanza Excepcion MaterialDestruidoNoSePuedeGolpearException.
        jugador.golpear(material);
    }

    @Test(expected = NoHayHerramientaEquipadaException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearMaderas51VecesYDesgastarse ()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);

        for(int i = 0; i < 10; i++) {
            Material material = new Madera();
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
            jugador.golpear(material);
        }

        Material material = new Madera();

        // Al golpe 51 se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
        jugador.golpear(material);
    }

    /*************************************************
     * JUGADOR CON HACHA DE MADERA GOLPEA UNA PIEDRA *
     *************************************************/

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedraYNoReducirLaDurabilidadDelMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Piedra();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedra50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Piedra();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = NoHayHerramientaEquipadaException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnaPiedra51VecesYDesgastarse()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Piedra();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        // Al golpe 51 se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
        jugador.golpear(material);
    }

    /***********************************************
     * JUGADOR CON HACHA DE MADERA GOLPEA UN METAL *
     ***********************************************/

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetalYNoReducirLaDurabilidadDelMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Metal();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetal50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Metal();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = NoHayHerramientaEquipadaException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnMetal51VecesYDesgastarse()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Metal();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        // Al golpe 51 se lanza Excepcion HerramientaDesgastadaNoSePuedeUsarException.
        jugador.golpear(material);
    }

    /**************************************************
     * JUGADOR CON HACHA DE MADERA GOLPEA UN DIAMANTE *
     **************************************************/

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamanteYNoReducirLaDurabilidadDelMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Diamante();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamante50VecesAntesDeDesgastarseYNoDestruirElMaterial()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Diamante();

        BigDecimal durabilidadDelMaterialInicial = material.getDurabilidad();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        assertEquals(durabilidadDelMaterialInicial, material.getDurabilidad());
    }

    @Test(expected = NoHayHerramientaEquipadaException.class)
    public void cuandoSeCreaUnJugador_DeberiaTenerUnHachaDeMaderaGolpearUnDiamante51VecesYDesgastarse()
            throws Exception {

        Jugador jugador = new Jugador();
        jugador.equipar(1);
        
        Material material = new Diamante();

        for(int i = 0; i < 50; i++)
            jugador.golpear(material);

        jugador.golpear(material);
    }

    /**************************************************************************
     * POSICION DE JUGADOR EN UN TERRENO Y DE LOS CASILLEROS LUEGO DE MOVERSE *
     **************************************************************************/

    @Test
    public void dadoUnJugador_DeberiaPoderPosicionarseEnUnCasilleroDeUnTerreno()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicion = new Posicion(1,1);
        OcupanteTerreno jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicion);
        
        assertEquals(jugador, terreno.obtenerOcupanteTerreno(posicion));
    }

    @Test
    public void dadoUnJugadorQueIntentaMoverseAUnCasilleroOcupado_DeberiaQuedarseEnElCasilleroQueEstaba()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2,2);
        Posicion posicionMaterial = new Posicion(3,2);
        Jugador jugador = new Jugador();
        Material material = new Diamante();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        try {
            jugador.mover(Direccion.DERECHA);
            fail("Deberia lanzar CasilleroOcupadoException");
        } catch(CasilleroOcupadoException e) {
        }

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionJugador);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorQueSeMueveAUnCasilleroDesocupado_DeberiaDejarDesocupadoElCasilleroEnElQueEstabaYOcupadoAlQueSeMovio()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionInicial = new Posicion(2,2);
        Posicion posicionFinal = new Posicion(3,2);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
		jugador.mover(Direccion.DERECHA);

        try {
            terreno.desocuparCasillero(posicionInicial);
            fail("Deberia lanzar CasilleroVacioException");
        } catch(CasilleroVacioException e) {
        }

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    /********************************************************************
     * MOVIMIENTOS DE JUGADOR EN ESQUINA INFERIOR IZQUIERDA DEL TABLERO *
     ********************************************************************/

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_DeberiaPoderMoverseHaciaLaDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,1);
        Posicion posicionFinal = new Posicion(2,1);
        Jugador jugador = new Jugador();
        
        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DERECHA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_DeberiaPoderMoverseALaDiagonalSuperiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,1);
        Posicion posicionFinal = new Posicion(2,2);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_DeberiaPoderMoverseHaciaArriba()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,1);
        Posicion posicionFinal = new Posicion(1,2);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ARRIBA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_NoDeberiaPoderMoverseALaDiagonalSuperiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_NoDeberiaPoderMoverseHaciaLaIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_NoDeberiaPoderMoverseALaDiagonalInferiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_NoDeberiaPoderMoverseHaciaAbajo()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ABAJO);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila1_NoDeberiaPoderMoverseALaDiagonalInferiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);
    }

    /******************************************************************
     * MOVIMIENTOS DE JUGADOR EN ESQUINA INFERIOR DERECHA DEL TABLERO *
     ******************************************************************/

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseHaciaLaDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DERECHA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseALaDiagonalSuperiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_DeberiaPoderMoverseHaciaArriba()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,1);
        Posicion posicionFinal = new Posicion(10,2);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ARRIBA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_DeberiaPoderMoverseALaDiagonalSuperiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,1);
        Posicion posicionFinal = new Posicion(9,2);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_DeberiaPoderMoverseHaciaLaIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,1);
        Posicion posicionFinal = new Posicion(9,1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.IZQUIERDA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseALaDiagonalInferiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseHaciaAbajo()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ABAJO);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila1_NoDeberiaPoderMoverseALaDiagonalInferiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 1);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);
    }

    /******************************************************************
     * MOVIMIENTOS DE JUGADOR EN ESQUINA SUPERIOR DERECHA DEL TABLERO *
     ******************************************************************/

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_NoDeberiaPoderMoverseHaciaLaDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DERECHA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_NoDeberiaPoderMoverseALaDiagonalSuperiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_NoDeberiaPoderMoverseHaciaArriba()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ARRIBA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_NoDeberiaPoderMoverseALaDiagonalSuperiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_DeberiaPoderMoverseHaciaLaIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,10);
        Posicion posicionFinal = new Posicion(9,10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.IZQUIERDA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_DeberiaPoderMoverseALaDiagonalInferiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,10);
        Posicion posicionFinal = new Posicion(9,9);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_DeberiaPoderMoverseHaciaAbajo()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10,10);
        Posicion posicionFinal = new Posicion(10,9);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ABAJO);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna10Fila10_NoDeberiaPoderMoverseALaDiagonalInferiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(10, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);
    }

    /********************************************************************
     * MOVIMIENTOS DE JUGADOR EN ESQUINA SUPERIOR IZQUIERDA DEL TABLERO *
     ********************************************************************/

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_DeberiaPoderMoverseHaciaLaDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,10);
        Posicion posicionFinal = new Posicion(2,10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DERECHA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_NoDeberiaPoderMoverseALaDiagonalSuperiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_NoDeberiaPoderMoverseHaciaArriba()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ARRIBA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_NoDeberiaPoderMoverseALaDiagonalSuperiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_NoDeberiaPoderMoverseHaciaLaIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.IZQUIERDA);
    }

    @Test(expected = CasilleroNoEncontradoException.class)
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_NoDeberiaPoderMoverseALaDiagonalInferiorIzquierda()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1, 10);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_DeberiaPoderMoverseHaciaAbajo()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,10);
        Posicion posicionFinal = new Posicion(1,9);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.ABAJO);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    @Test
    public void dadoUnJugadorEnUnTerrenoVacioDe10x10yEnPosicionColumna1Fila10_DeberiaPoderMoverseALaDiagonalInferiorDerecha()
            throws Exception {

        Terreno terreno = new Terreno(10, 10);
        Posicion posicionInicial = new Posicion(1,10);
        Posicion posicionFinal = new Posicion(2,9);
        Jugador jugador = new Jugador();

        terreno.ocuparCasillero(jugador, posicionInicial);
        jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);

        OcupanteTerreno ocupanteTerreno = terreno.obtenerOcupanteTerreno(posicionFinal);
        assertEquals(jugador, ocupanteTerreno);
    }

    /***************************************************
     * MOVIMIENTOS DE JUGADOR CON MATERIALES ALREDEDOR *
     ***************************************************/

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuDerecha_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(3, 2);
        Jugador jugador = new Jugador();
        Material material = new Madera();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.DERECHA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuDiagonalSuperiorDerecha_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(3, 3);
        Jugador jugador = new Jugador();
        Material material = new Madera();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.DIAGONAL_SUPERIOR_DERECHA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialArriba_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(2, 3);
        Jugador jugador = new Jugador();
        Material material = new Piedra();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.ARRIBA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuDiagonalSuperiorIzquierda_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(1, 3);
        Jugador jugador = new Jugador();
        Material material = new Piedra();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.DIAGONAL_SUPERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuIzquierda_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(1, 2);
        Jugador jugador = new Jugador();
        Material material = new Metal();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.IZQUIERDA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuDiagonalInferiorIzquierda_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(1, 1);
        Jugador jugador = new Jugador();
        Material material = new Metal();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.DIAGONAL_INFERIOR_IZQUIERDA);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialAbajo_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(2, 1);
        Jugador jugador = new Jugador();
        Material material = new Diamante();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.ABAJO);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void dadoUnJugadorEnUnTerrenoConUnMaterialASuDiagonalInferiorDerecha_NoDeberiaPoderMoverseEnEsaDireccion()
            throws Exception {

        Terreno terreno = new Terreno(3, 3);
        Posicion posicionJugador = new Posicion(2, 2);
        Posicion posicionMaterial = new Posicion(3, 1);
        Jugador jugador = new Jugador();
        Material material = new Diamante();

        terreno.ocuparCasillero(jugador, posicionJugador);
        terreno.ocuparCasillero(material, posicionMaterial);

        jugador.mover(Direccion.DIAGONAL_INFERIOR_DERECHA);
    }
}