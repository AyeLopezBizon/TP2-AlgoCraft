package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.*;

public class CreadorHerramienta {
	
	private MesaDeTrabajoVacia mesaDeTrabajo;
	private MesaDeTrabajo[] mesasDeTrabajosPredeterminadas;
	
	public CreadorHerramienta(MesaDeTrabajoVacia mesaDeTrabajo) throws PosicionIncorrectaException{
		this.mesaDeTrabajo = mesaDeTrabajo;

		mesasDeTrabajosPredeterminadas = new MesaDeTrabajo[7];
		mesasDeTrabajosPredeterminadas[0] = new MesaDeTrabajoHachaMadera();
		mesasDeTrabajosPredeterminadas[1] = new MesaDeTrabajoHachaPiedra();
		mesasDeTrabajosPredeterminadas[2] = new MesaDeTrabajoHachaMetal();
		mesasDeTrabajosPredeterminadas[3] = new MesaDeTrabajoPicoMadera();
		mesasDeTrabajosPredeterminadas[4] = new MesaDeTrabajoPicoPiedra();
		mesasDeTrabajosPredeterminadas[5] = new MesaDeTrabajoPicoMetal();
		mesasDeTrabajosPredeterminadas[6] = new MesaDeTrabajoPicoFino();			
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
