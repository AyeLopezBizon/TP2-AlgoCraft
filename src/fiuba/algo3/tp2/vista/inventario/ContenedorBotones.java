package fiuba.algo3.tp2.vista.inventario;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContenedorBotones extends VBox{
	
	public ContenedorBotones(){
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		
		Button botonCrear = new Button();
		botonCrear.setText("Crear herramienta");
		Button botonAgregar = new Button();
		botonAgregar.setText("AgregarMaterial");
		Button botonQuitar = new Button();
		botonQuitar.setText("QuitarMaterial");
		
		this.getChildren().addAll(botonCrear, botonAgregar, botonQuitar);
	}
}
