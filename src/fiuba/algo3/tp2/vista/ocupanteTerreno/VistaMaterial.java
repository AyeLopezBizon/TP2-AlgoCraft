package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.math.BigDecimal;
import java.util.Observable;

import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class VistaMaterial extends Vista implements VistaOcupanteTerreno {

	private VistaCasilleroTerreno vistaCasilleroTerreno;
	private Material material;
	private boolean materialYaSeEncuentraDebilitado;
	private RotateTransition transicionGolpe;
	private ImageView imageView;
	private Image imagenMaterial;
	private Image imagenMaterialDebilitado;
	

	public VistaMaterial(VistaCasilleroTerreno vistaCasilleroTerreno, OcupanteTerreno ocupanteTerreno) {
		
		this.vistaCasilleroTerreno = vistaCasilleroTerreno;
		this.material = (Material)ocupanteTerreno;
		this.transicionGolpe = crearTransicionGolpe();
		this.imagenMaterial = obtenerImagenMaterial();
		this.imagenMaterialDebilitado = obtenerImagenMaterialDebilitado();
		
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(vistaCasilleroTerreno.widthProperty());
        imageView.fitHeightProperty().bind(vistaCasilleroTerreno.heightProperty());
        
        vistaCasilleroTerreno.getChildren().add(imageView);
	}
	
	private Image obtenerImagenMaterialDebilitado() {
		String nombreImagen = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + material.getClass().getSimpleName() + "MitadVida.png";
		return new Image(nombreImagen);
	}

	private Image obtenerImagenMaterial() {
		String nombreImagen = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + material.getClass().getSimpleName() + ".png";
		return new Image(nombreImagen);
	}

	@Override
	public void update(Observable o, Object arg) {

		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];

		if(accion.equals("reducirDurabilidad")) {

			BigDecimal danio = (BigDecimal)parametros[1];
			BigDecimal durabilidad = (BigDecimal)parametros[2];
			BigDecimal durabilidadMaxima = (BigDecimal)parametros[3];
			
			transicionGolpe.play();
			ReproductorSonido.reproducir("GOLPE_MATERIAL");
			dibujarMaterialDebilitado(durabilidad, durabilidadMaxima);
		} else if(accion.equals("materialDestruido")) {
			ReproductorSonido.reproducir("RECOGER_UNIDAD_MATERIAL");
		}
	}

	private void dibujarMaterialDebilitado(BigDecimal durabilidad, BigDecimal durabilidadMaxima) {

		if(!materialYaSeEncuentraDebilitado) {

			if(durabilidad.compareTo(durabilidadMaxima.divide(new BigDecimal(2))) <= 0) {

				imageView.setImage(imagenMaterialDebilitado);
				materialYaSeEncuentraDebilitado = true;
			}
		}
	}

	private RotateTransition crearTransicionGolpe() {
		
		RotateTransition trans = new RotateTransition(Duration.seconds(0.1), vistaCasilleroTerreno);
        trans.setFromAngle(0.0);
        trans.setToAngle(20.0);
        trans.setCycleCount(2);
        trans.setAutoReverse(true);
		return trans;
	}

	@Override
	public void dibujar() {
		
		imageView.setImage(imagenMaterial);
	}
}