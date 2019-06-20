package fiuba.algo3.tp2.modelo.jugador;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import fiuba.algo3.tp2.modelo.jugador.movimiento.Movimiento;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

public class Jugador implements OcupanteTerreno {
	
	private static final Integer CAPACIDAD_INICIAL_INVENTARIO = 10;
	
    private Herramienta herramientaActiva;
    private Inventario inventario;
    private Posicion posicion;
    private Terreno terreno;
    
    
    public Jugador() throws NoSePuedeInicializarJugador {
    	
    	this.inventario = new Inventario(CAPACIDAD_INICIAL_INVENTARIO);
    	Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
    	try {
    		inventario.almacenar(hachaDeMadera);
    	}catch(InventarioLlenoException | NoSePudoAlmacenarItemException e) {
    		throw new NoSePuedeInicializarJugador(e);
    	}
    	
    }
    
	public void equipar(Integer numeroEspacioInventario) throws EspacioVacioException {
		
		Almacenable almacenable = inventario.obtenerAlmacenable(numeroEspacioInventario);
		almacenable.equiparEn(this);
		inventario.quitar(numeroEspacioInventario);
	}
	
	public void equipar(Herramienta herramienta) {
		herramientaActiva = herramienta;
	}
	
    public void golpear(Material material)
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        this.herramientaActiva.golpear(material);
    }
    
    public void lanzarGolpe(DireccionGolpe direccionGolpe) 
    		throws CasilleroNoEncontradoException, CasilleroVacioException {
    	direccionGolpe.lanzarGolpe(posicion);
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

		Posicion posicionInicial = this.posicion;
		Posicion posicionFinal = movimiento.mover(this.posicion);
		terreno.ocuparCasillero(this, posicionFinal);
		terreno.desocuparCasillero(posicionInicial);
	}

	@Override
	public void recibirGolpe(Jugador jugador) {
		// No pasa nada
	}

	public void almacenar(Almacenable almacenable) 
			throws InventarioLlenoException, NoSePudoAlmacenarItemException {
		inventario.almacenar(almacenable);
	}

	@Override
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
}