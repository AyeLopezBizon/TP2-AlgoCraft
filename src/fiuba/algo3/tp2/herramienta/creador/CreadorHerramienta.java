package fiuba.algo3.tp2.herramienta.creador;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.*;

public class CreadorHerramienta {
	
	Tablero tablero;
	Tablero[] tablerosPredeterminados;
	
	CreadorHerramienta(Tablero tablero){
		this.tablero=tablero;
		tablerosPredeterminados = new Tablero[7];
		tablerosPredeterminados[0] = TableroFactory.newTableroHachaMadera();
		tablerosPredeterminados[1] = TableroFactory.newTableroHachaPiedra();
		tablerosPredeterminados[2] = TableroFactory.newTableroHachaMetal();
		tablerosPredeterminados[3] = TableroFactory.newTableroPicoMadera();
		tablerosPredeterminados[4] = TableroFactory.newTableroPicoPiedra();
		tablerosPredeterminados[5] = TableroFactory.newTableroPicoMetal();
		tablerosPredeterminados[6] = TableroFactory.newTableroPicoFino();			
	}
	
	public Herramienta crearHerramienta() throws MaterialesMalPosicionadosException {
		Herramienta herramienta;
		
		herramienta = comparar();
		
		return herramienta;
	}
	
	private Herramienta comparar() throws MaterialesMalPosicionadosException {
		Herramienta herramienta = null;
		
		for(int i=0;i<7;i++){
			if(tablerosPredeterminados[i].comparar(tablero)){
				herramienta=tablerosPredeterminados[i].crearHerramienta();
			}
		}
		if(herramienta==null) {
			throw new MaterialesMalPosicionadosException();
		}
		return herramienta;
		
	}
}
