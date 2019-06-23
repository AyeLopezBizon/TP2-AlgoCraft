package fiuba.algo3.tp2.modelo.herramienta.creador;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;

public class CreadorHerramienta {

	private Collection<MesaDeTrabajo> mesasDeTrabajoPredeterminadas;
	
	public CreadorHerramienta()
			throws NoSePuedeInicializarMesaDeTrabajoException{

		mesasDeTrabajoPredeterminadas = new ArrayList<>();
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoFino());			
	}
	
	public Herramienta crearHerramienta(MesaDeTrabajo mesaDeTrabajo)
			throws MaterialesMalPosicionadosException, NoSePuedeInicializarMesaDeTrabajoException, MesaDeTrabajoIncorrectaException, CasilleroNoEncontradoException, CasilleroVacioException {

		Herramienta herramientaADevolver = null;

		try {
			herramientaADevolver = asignarMesaDeTrabajoCorrespondiente(mesaDeTrabajo);
		}catch(MesaDeTrabajoIncorrectaException e){
			throw new MaterialesMalPosicionadosException();
		}

		mesaDeTrabajo.limpiarMesaDeTrabajo();

		return herramientaADevolver;
	}
	
	private Herramienta asignarMesaDeTrabajoCorrespondiente(MesaDeTrabajo mesaDeTrabajo) throws MesaDeTrabajoIncorrectaException {
		
		for(MesaDeTrabajo mesaDeTrabajoPredeterminada : mesasDeTrabajoPredeterminadas) {
			if(mesaDeTrabajoPredeterminada.comparar(mesaDeTrabajo)) {
				return mesaDeTrabajoPredeterminada.crearHerramienta();
			}
		}

		throw new MesaDeTrabajoIncorrectaException();
	}

}
