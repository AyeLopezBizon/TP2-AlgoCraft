package fiuba.algo3.tp2.vista.ocupanteTerreno;

import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public abstract class Vista {

    public Background obtenerImagen(String nombreImagen) {

        String path = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/";
        String imagePath =  path + nombreImagen;

        Image imagen = new Image(imagePath,
                VistaTerreno.TAMANIO_NODO,
                VistaTerreno.TAMANIO_NODO,
                false,
                true);

        BackgroundImage fondo = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        return new Background(fondo);
    }
}