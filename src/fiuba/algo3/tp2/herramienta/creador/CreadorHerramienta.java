package fiuba.algo3.tp2.herramienta.creador;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.*;

public class CreadorHerramienta {
	
	private MesaDeTrabajo mesaDeTrabajo;
	private MesaDeTrabajo[] mesasDeTrabajosPredeterminadas;
	
	public CreadorHerramienta(MesaDeTrabajo mesaDeTrabajo) throws PosicionIncorrectaException{
		this.mesaDeTrabajo = mesaDeTrabajo;

		mesasDeTrabajosPredeterminadas = new MesaDeTrabajo[7];
		mesasDeTrabajosPredeterminadas[0] = MesaDeTrabajoFactory.newMesaDeTrabajoHachaMadera();
		mesasDeTrabajosPredeterminadas[1] = MesaDeTrabajoFactory.newMesaDeTrabajoHachaPiedra();
		mesasDeTrabajosPredeterminadas[2] = MesaDeTrabajoFactory.newMesaDeTrabajoHachaMetal();
		mesasDeTrabajosPredeterminadas[3] = MesaDeTrabajoFactory.newMesaDeTrabajoPicoMadera();
		mesasDeTrabajosPredeterminadas[4] = MesaDeTrabajoFactory.newMesaDeTrabajoPicoPiedra();
		mesasDeTrabajosPredeterminadas[5] = MesaDeTrabajoFactory.newMesaDeTrabajoPicoMetal();
		mesasDeTrabajosPredeterminadas[6] = MesaDeTrabajoFactory.newMesaDeTrabajoPicoFino();			
	}
	
	public Herramienta crearHerramienta() throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Herramienta herramienta;
		herramienta = comparar();
		return herramienta;
	}
	
	private Herramienta comparar() throws MaterialesMalPosicionadosException, PosicionIncorrectaException {		
		for(int i=0;i<7;i++){
			if(mesasDeTrabajosPredeterminadas[i].comparar(mesaDeTrabajo)){
				return mesasDeTrabajosPredeterminadas[i].crearHerramienta();
			}
		}
		throw new MaterialesMalPosicionadosException();		
	}
}
