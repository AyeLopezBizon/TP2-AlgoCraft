package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;

public class MesaDeTrabajoFactory {

	public static MesaDeTrabajo newMesaDeTrabajoHachaMadera() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoHachaMadera();
		mesaDeTrabajo.setMaterial(new Madera(), 1);
		mesaDeTrabajo.setMaterial(new Madera(), 2);
		mesaDeTrabajo.setMaterial(new Madera(), 4);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoHachaPiedra() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoHachaPiedra();
		mesaDeTrabajo.setMaterial(new Piedra(), 1);
		mesaDeTrabajo.setMaterial(new Piedra(), 2);
		mesaDeTrabajo.setMaterial(new Piedra(), 4);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoHachaMetal() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoHachaMetal();
		mesaDeTrabajo.setMaterial(new Metal(), 1);
		mesaDeTrabajo.setMaterial(new Metal(), 2);
		mesaDeTrabajo.setMaterial(new Metal(), 4);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoPicoMadera() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoPicoMadera();
		mesaDeTrabajo.setMaterial(new Madera(), 1);
		mesaDeTrabajo.setMaterial(new Madera(), 2);
		mesaDeTrabajo.setMaterial(new Madera(), 3);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoPicoPiedra() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoPicoPiedra();
		mesaDeTrabajo.setMaterial(new Piedra(), 1);
		mesaDeTrabajo.setMaterial(new Piedra(), 2);
		mesaDeTrabajo.setMaterial(new Piedra(), 3);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoPicoMetal() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoPicoMetal();
		mesaDeTrabajo.setMaterial(new Metal(), 1);
		mesaDeTrabajo.setMaterial(new Metal(), 2);
		mesaDeTrabajo.setMaterial(new Metal(), 3);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}
	
	public static MesaDeTrabajo newMesaDeTrabajoPicoFino() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo= new MesaDeTrabajoPicoFino();
		mesaDeTrabajo.setMaterial(new Metal(), 1);
		mesaDeTrabajo.setMaterial(new Metal(), 2);
		mesaDeTrabajo.setMaterial(new Metal(), 3);
		mesaDeTrabajo.setMaterial(new Piedra(), 4);
		mesaDeTrabajo.setMaterial(new Madera(), 5);
		mesaDeTrabajo.setMaterial(new Madera(), 8);
		return mesaDeTrabajo;
	}

}
