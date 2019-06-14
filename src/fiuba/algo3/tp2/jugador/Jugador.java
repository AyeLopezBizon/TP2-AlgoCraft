package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.jugador.movimiento.Movimiento;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.terreno.Terreno;

public class Jugador implements OcupanteTerreno {
	
    private Herramienta herramientaActiva;
    private Inventario inventario;
    private Posicion posicion;
    
    
    public Jugador() {
    	this.inventario = new Inventario();
        this.herramientaActiva = this.inventario.getHachaDeMadera();
    }
	
    public void golpear(Material material)
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        this.herramientaActiva.golpear(material);
    }

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}

    public void mover(Movimiento movimiento, Terreno terreno)
			throws CasilleroNoEncontradoException, CasilleroOcupadoException, CasilleroVacioException {

		terreno.desocuparCasillero(this.posicion);
		this.posicion = movimiento.mover(this.posicion);
		terreno.ocuparCasillero(this, this.posicion);
    }

	@Override
	public void recibirGolpe(Jugador jugador) {
		// No pasa nada
	}
}