package fiuba.algo3.tp2.vista.inventario;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorBotones extends VBox{
	
	public ContenedorBotones(){
		
		setAlignment(Pos.CENTER_RIGHT);
		//this.setSpacing(20);
		this.setPadding(new Insets(0, 0, 0, 20));
		
		Button botonCrear = new Button();
		botonCrear.setText("CREAR");
		botonCrear.setTextFill(Color.WHITE);
		botonCrear.setPrefHeight(50);
		botonCrear.setPrefWidth(100);
		botonCrear.setStyle(this.obtenerEstiloBoton());
		
		this.getChildren().addAll(botonCrear);
	}
	
    private String obtenerEstiloBoton() {
    	
    	return "  -fx-border-size: 5px;" +
        		"  -fx-border-style: solid;" +
        		"  -fx-border-radius: 5px;" +
        		"  -fx-font-size: 15px;" + 
        		"  -fx-font-family: Arial, Helvetica, sans-serif;" +
        		"  -fx-font-weight: bold;" + 
        		"  -fx-background-color: #4C1919;" + 
        		"  -fx-background-size: 13px 13px, 29px 29px, 37px 37px, 53px 53px;" +
        		"  -fx-background-radius: 5px;";
    }
}
