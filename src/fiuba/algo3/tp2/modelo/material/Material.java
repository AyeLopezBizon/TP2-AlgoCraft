package fiuba.algo3.tp2.modelo.material;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.modelo.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.modelo.herramienta.golpe.Golpeable;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;

public abstract class Material extends Observable implements Golpeable, OcupanteTerreno {
	
	@Override
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	private Terreno terreno;
	protected BigDecimal durabilidad;
	private BigDecimal durabilidadMaxima;
	private Posicion posicion;
	
	public Material(BigDecimal durabilidad) {
		this.durabilidad = durabilidad;
		this.durabilidadMaxima = durabilidad;
	}
	
	@Override
	public void addObserver(Observer observer) {
		super.addObserver(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		super.deleteObserver(observer);
	}

	@Override
	public void recibirGolpe(Jugador jugador) {
		
		try {
			jugador.golpear(this);
			System.out.println(durabilidad);
			if(estaRoto()) {
				terreno.desocuparCasillero(posicion);
				jugador.almacenar(obtenerUnidadMaterial());
			}
		}catch(Exception e) {
			//TODO Tratar de manera correcta
		}
	}

	private boolean estaRoto() {
		return durabilidad.equals(new BigDecimal(0));
	}

	protected abstract UnidadMaterial obtenerUnidadMaterial();

	public BigDecimal getDurabilidad() {
		return durabilidad;
	}
	
	public void reducirDurabilidad(BigDecimal danio)
			throws MaterialDestruidoNoSePuedeGolpearException {
		
		if(durabilidad.equals(new BigDecimal(0))) {
			throw new MaterialDestruidoNoSePuedeGolpearException();
		}
		
		durabilidad = durabilidad.subtract(danio);
		
		// La durabilidad no puede ser negativa, 
		// si el danio es mayor a la durabilidad se setea en 0
		if(durabilidad.compareTo(new BigDecimal(0)) < 0){
			durabilidad = new BigDecimal(0);
		}
		
		setChanged();
		notifyObservers(new Object[] { "reducirDurabilidad", danio, durabilidad, durabilidadMaxima });
	}

	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	public abstract void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException;
}