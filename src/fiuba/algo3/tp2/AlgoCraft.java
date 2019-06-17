package fiuba.algo3.tp2;

import fiuba.algo3.tp2.vista.inicio.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoCraft extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Algo Craft");
		
		ContenedorInicio contenedorInicio = new ContenedorInicio(primaryStage);
        Scene escenaBienvenidos = new Scene(contenedorInicio);
		
		primaryStage.setScene(escenaBienvenidos);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
}
