package fiuba.algo3.tp2.modelo.jugador;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

public class Jugador extends Observable implements OcupanteTerreno {
	
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
	}
	
	public void equipar(Herramienta herramienta) throws EspacioVacioException {
		
		herramientaActiva = herramienta;
		inventario.quitar(herramienta.obtenerNumeroEspacioInventario());
		
		setChanged();
		notifyObservers(new Object[] { "equipar", herramientaActiva });
	}
	
	public void desequipar() throws InventarioLlenoException, NoSePudoAlmacenarItemException {
		
		inventario.almacenar(herramientaActiva);
		herramientaActiva.desequiparDe(this);
		herramientaActiva = null;
		
		setChanged();
		notifyObservers(new Object[] { "desequipar", herramientaActiva });
	}
	
    public void golpear(Material material)
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        this.herramientaActiva.golpear(material);
    }
    
    public void lanzarGolpe(Direccion direccionGolpe) 
    		throws CasilleroNoEncontradoException, CasilleroVacioException {
    	
    	Posicion posicionALanzarGolpe = direccionGolpe.obtenerPosicion(posicion);
    	OcupanteTerreno ocupanteAGolpear = terreno.obtenerOcupanteTerreno(posicionALanzarGolpe);
    	ocupanteAGolpear.recibirGolpe(this);
    	
    	
    	setChanged();
    	notifyObservers(new Object[] {"lanzarGolpe"});
    }

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}

	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}

    public void mover(Direccion direccion)
			throws CasilleroNoEncontradoException, CasilleroOcupadoException, CasilleroVacioException {

		Posicion posicionInicial = this.posicion;
		Posicion posicionFinal = direccion.obtenerPosicion(posicion);
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

	@Override
	public void addObserver(Observer obsever) {
		super.addObserver(obsever);
	}
	
	@Override
	public void removeObserver(Observer obsever) {
		super.deleteObserver(obsever);
	}

	public Inventario obtenerInventario() {
		return inventario;
	}

	public void destruirHerramienta(Herramienta herramienta) {
		
		this.herramientaActiva = null;
		
		setChanged();
		notifyObservers(new Object[] {"destruirHerramienta"});
	}
}