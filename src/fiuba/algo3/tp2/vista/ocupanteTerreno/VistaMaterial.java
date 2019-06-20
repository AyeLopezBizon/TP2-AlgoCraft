package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Observable;

import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public abstract class VistaMaterial implements VistaOcupanteTerreno {

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
				
				vistaCasilleroTerreno.setBackground(obtenerImagenMaterialDebilitado());
				materialYaSeEncuentraDebilitado = true;
			}
		}
	}

	private Background obtenerImagenMaterialDebilitado() {
		
		String nombreImagen = material.getClass().getSimpleName() + "MitadVida.png";

		String imagePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + nombreImagen;

		Image imagen = new Image(imagePath,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		System.out.println(imagePath);
		return new Background(fondo);
	}

	private void dibujarDanio(BigDecimal danio) {
		System.out.println("REDUCCION DE DURABILIDAD EN" + danio);
	}

	@Override
	public void dibujar() {
		vistaCasilleroTerreno.setBackground(obtenerImagen());
	}
	
	private Background obtenerImagen() {
		
		String nombreImagen = material.getClass().getSimpleName() + ".png";

		String imagePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + nombreImagen;

		Image imagen = new Image(imagePath,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		System.out.println(imagePath);
		return new Background(fondo);
	}
}
