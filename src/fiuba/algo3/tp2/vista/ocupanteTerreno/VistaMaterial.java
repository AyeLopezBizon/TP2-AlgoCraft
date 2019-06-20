package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.math.BigDecimal;
import java.util.Observable;

import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;

public abstract class VistaMaterial extends Vista implements VistaOcupanteTerreno {

	private VistaCasilleroTerreno vistaCasilleroTerreno;
	private Material material;
	private boolean materialYaSeEncuentraDebilitado;

	public VistaMaterial(VistaCasilleroTerreno vistaCasilleroTerreno, OcupanteTerreno ocupanteTerreno) {
		this.vistaCasilleroTerreno = vistaCasilleroTerreno;
		this.material = (Material)ocupanteTerreno;
	}

	@Override
	public void update(Observable o, Object arg) {

		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];

		if(accion.equals("reducirDurabilidad")) {

			BigDecimal danio = (BigDecimal)parametros[1];
			BigDecimal durabilidad = (BigDecimal)parametros[2];
			BigDecimal durabilidadMaxima = (BigDecimal)parametros[3];

			dibujarDanio(danio);
			dibujarMaterialDebilitado(durabilidad, durabilidadMaxima);
		}
	}

	private void dibujarMaterialDebilitado(BigDecimal durabilidad, BigDecimal durabilidadMaxima) {

		if(!materialYaSeEncuentraDebilitado) {

			if(durabilidad.compareTo(durabilidadMaxima.divide(new BigDecimal(2))) <= 0) {

				String nombreImagen = material.getClass().getSimpleName() + "MitadVida.png";
				vistaCasilleroTerreno.setBackground(obtenerImagen(nombreImagen));
				materialYaSeEncuentraDebilitado = true;
			}
		}
	}

	private void dibujarDanio(BigDecimal danio) {
		System.out.println("REDUCCION DE DURABILIDAD EN" + danio);
	}

	@Override
	public void dibujar() {
		String nombreImagen = material.getClass().getSimpleName() + ".png";
		vistaCasilleroTerreno.setBackground(obtenerImagen(nombreImagen));
	}
}