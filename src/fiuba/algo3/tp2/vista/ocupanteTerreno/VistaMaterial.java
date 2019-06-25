package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.math.BigDecimal;
import java.util.Observable;

import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.notificacion.Notificacion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import fiuba.algo3.tp2.vista.Imagen;
import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import fiuba.algo3.tp2.vista.sonido.Sonido;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public abstract class VistaMaterial implements VistaOcupanteTerreno {

	private ContenedorCasillero contenedor;
	private Material material;
	private boolean materialYaSeEncuentraDebilitado;
	
	private RotateTransition transicionGolpe;
	private Image imagenMaterial;
	private Image imagenMaterialDebilitado;
	

	public VistaMaterial(ContenedorCasillero contenedor, OcupanteTerreno ocupanteTerreno) {
		
		this.contenedor = contenedor;
		this.material = (Material)ocupanteTerreno;
		this.transicionGolpe = crearTransicionGolpe();
		this.imagenMaterial = obtenerImagenMaterial();
		this.imagenMaterialDebilitado = obtenerImagenMaterialDebilitado();
	}
	
	private Image obtenerImagenMaterialDebilitado() {
		String nombreImagen = Imagen.obtenerImagenMaterialDebilitado(material.getClass().getSimpleName());
		return new Image(nombreImagen);
	}

	private Image obtenerImagenMaterial() {
		String nombreImagen = Imagen.obtenerImagenMaterial(material.getClass().getSimpleName());
		return new Image(nombreImagen);
	}
	
	private RotateTransition crearTransicionGolpe() {
		
		RotateTransition trans = new RotateTransition(Duration.seconds(0.1), contenedor);
        trans.setFromAngle(0.0);
        trans.setToAngle(20.0);
        trans.setCycleCount(2);
        trans.setAutoReverse(true);
		return trans;
	}

	@Override
	public void dibujar() {
		
		contenedor.dibujar(imagenMaterial);
	}
	
	private void dibujarMaterialDebilitado(BigDecimal durabilidad, BigDecimal durabilidadMaxima) {

		if(!materialYaSeEncuentraDebilitado) {
			if(durabilidad.compareTo(durabilidadMaxima.divide(new BigDecimal(2))) <= 0) {
				contenedor.dibujar(imagenMaterialDebilitado);
				materialYaSeEncuentraDebilitado = true;
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];

		if(accion.equals(Notificacion.REDUCIR_DURABILIDAD)) {
			
			BigDecimal durabilidad = (BigDecimal)parametros[2];
			BigDecimal durabilidadMaxima = (BigDecimal)parametros[3];
			
			transicionGolpe.play();
			ReproductorSonido.reproducir(Sonido.GOLPE_MATERIAL);
			dibujarMaterialDebilitado(durabilidad, durabilidadMaxima);
			
		} else if(accion.equals(Notificacion.MATERIAL_DESTRUIDO)) {
			
			ReproductorSonido.reproducir(Sonido.RECOGER_UNIDAD_MATERIAL);
		}
	}
}