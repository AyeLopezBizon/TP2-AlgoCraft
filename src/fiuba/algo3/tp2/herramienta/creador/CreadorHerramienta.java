package fiuba.algo3.tp2.herramienta.creador;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.herramienta.Herramienta;

public class CreadorHerramienta {
	
	private MesaDeTrabajo mesaDeTrabajo;
	private Collection<MesaDeTrabajo> mesasDeTrabajoPredeterminadas;
	
	public CreadorHerramienta(MesaDeTrabajo mesaDeTrabajo) 
			throws NoSePuedeInicializarMesaDeTrabajoException{
		
		this.mesaDeTrabajo = mesaDeTrabajo;
		mesasDeTrabajoPredeterminadas = new ArrayList<>();
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoFino());			
	}
	
	public Herramienta crearHerramienta()
			throws MaterialesMalPosicionadosException, NoSePuedeInicializarMesaDeTrabajoException, MesaDeTrabajoIncorrectaException {
		
		if(!mesaDeTrabajoEstaBienArmada()) {
			throw new MaterialesMalPosicionadosException();
		}
		
		asignarMesaDeTrabajoCorrespondiente();
		
		Herramienta herramientaADevolver = mesaDeTrabajo.crearHerramienta();

		mesaDeTrabajo = new MesaDeTrabajoVacia();

		return herramientaADevolver;
	}
	
	private boolean mesaDeTrabajoEstaBienArmada() {
		
		for(MesaDeTrabajo mesaDeTrabajo : mesasDeTrabajoPredeterminadas) {
			if(mesaDeTrabajo.comparar(this.mesaDeTrabajo)) {
				return true;
			}
		}
		return false;
	}
	
	private void asignarMesaDeTrabajoCorrespondiente() {
		
		for(MesaDeTrabajo mesaDeTrabajo : mesasDeTrabajoPredeterminadas) {
			if(mesaDeTrabajo.comparar(this.mesaDeTrabajo)) {
				this.mesaDeTrabajo = mesaDeTrabajo;			}
		}
	}
}
