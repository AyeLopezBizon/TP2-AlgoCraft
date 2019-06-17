package fiuba.algo3.tp2.jugador.inventario;

import fiuba.algo3.tp2.matriz.Matriz;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class Inventario {
	
	private Matriz<Almacenable> itemsInventario;
	private Integer capacidad;
	private Integer cantidadEspaciosOcupados;
    
	
    public Inventario(Integer capacidad) {
    	
    	this.capacidad = capacidad;
    	this.cantidadEspaciosOcupados = 0;
    	itemsInventario = new Matriz<Almacenable>(capacidad, 1);
	}
    
	public Integer obtenerCapacidad() {
		return this.capacidad;
	}

	public void almacenar(Almacenable almacenable) 
			throws InventarioLlenoException, NoSePudoAlmacenarItemException {
		
		if(capacidad.equals(cantidadEspaciosOcupados)) {
			throw new InventarioLlenoException();
		}
		try {
			almacenarEnPrimerEspacioDesocupado(almacenable);
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException e) {
			throw new NoSePudoAlmacenarItemException();
		}
		cantidadEspaciosOcupados++;
	}
	
	public Almacenable obtenerAlmacenable(Integer numeroEspacioInventario) throws EspacioVacioException {
		
		Almacenable almacenable = null;
		try {
			almacenable = itemsInventario.obtenerValor(new Posicion(numeroEspacioInventario, 1));
		} catch (CasilleroNoEncontradoException | CasilleroVacioException e) {
			throw new EspacioVacioException();
		}
		
		return almacenable;
	}
	
	public void quitar(Integer numeroEspacioInventario) throws EspacioVacioException {
		
		try {
			itemsInventario.desocuparCasillero(new Posicion(numeroEspacioInventario, 1));
		} catch (CasilleroNoEncontradoException | CasilleroVacioException e) {
			throw new EspacioVacioException();
		}
	}
	
	private void almacenarEnPrimerEspacioDesocupado(Almacenable almacenable) 
			throws CasilleroNoEncontradoException, CasilleroOcupadoException {
		
		Posicion posicionaAOcupar = null;
		Boolean itemFueAlmacenado = false;
		
		for(int indiceInventario = 1; indiceInventario <= capacidad && !itemFueAlmacenado; indiceInventario++) {
			try {
				posicionaAOcupar = new Posicion(indiceInventario, 1);
				itemsInventario.obtenerValor(posicionaAOcupar);
			} catch(CasilleroVacioException e) {
				itemsInventario.ocuparCasillero(almacenable, posicionaAOcupar);
				itemFueAlmacenado = true;
			}
		}
	}
}
