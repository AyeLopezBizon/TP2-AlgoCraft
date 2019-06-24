package fiuba.algo3.tp2.modelo.herramienta.creador;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMadera;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadPiedra;

public class MesaDeTrabajoPicoPiedra extends MesaDeTrabajo{

	public MesaDeTrabajoPicoPiedra() 
			throws NoSePuedeInicializarMesaDeTrabajoException {
		
		super();
		
		try {
			agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(1), new Integer(1)));
			agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(2), new Integer(1)));
			agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(3), new Integer(1)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(3)));
		} catch(PosicionIncorrectaException e) {
			throw new NoSePuedeInicializarMesaDeTrabajoException();
		}
	}
	
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newPicoDePiedra();
	}
}
