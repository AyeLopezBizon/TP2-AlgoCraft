package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.jugador.inventario.Inventario;
import fiuba.algo3.tp2.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.jugador.inventario.NoSePudoAlmacenarItemException;
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