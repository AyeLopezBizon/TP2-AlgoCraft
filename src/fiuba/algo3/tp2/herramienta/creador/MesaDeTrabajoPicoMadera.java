package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.unidadMaterial.UnidadMadera;

public class MesaDeTrabajoPicoMadera extends MesaDeTrabajo{

	public MesaDeTrabajoPicoMadera()
			throws NoSePuedeInicializarMesaDeTrabajoException {
		
		super();
		
		try {
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(1)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(2)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(3)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
			agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		} catch (PosicionIncorrectaException e) {
			throw new NoSePuedeInicializarMesaDeTrabajoException();
		}
	}
	
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newPicoDeMadera();
	}
}
