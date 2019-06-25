package fiuba.algo3.tp2.vista.inventario;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BarraDurabilidad extends StackPane {
	
	private Pane barraDurabilidadActual;
	private Label durabildadTexto;

	public BarraDurabilidad() {
		
		setAlignment(Pos.CENTER_LEFT);
		setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(0, 1, 1, 0.5), new CornerRadii(5), null)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
		
		setPrefHeight(15);
		setMaxHeight(15);
		
		barraDurabilidadActual = new Pane();
		barraDurabilidadActual.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), null)));
		
		durabildadTexto = new Label();
		durabildadTexto.setAlignment(Pos.CENTER);
		durabildadTexto.setFont(Font.font(10));
		durabildadTexto.maxWidthProperty().bind(widthProperty());
		
		getChildren().add(barraDurabilidadActual);
		getChildren().add(durabildadTexto);
	}
	
	public void dibujar(double maximaDurabilidad, double durabilidadActual) {
		
		barraDurabilidadActual.maxWidthProperty().bind(widthProperty().multiply(durabilidadActual / maximaDurabilidad));
		durabildadTexto.setText(new BigDecimal(durabilidadActual).setScale(2, RoundingMode.HALF_DOWN) 
				+ "/" 
				+ new BigDecimal(maximaDurabilidad).setScale(2, RoundingMode.HALF_DOWN));
	}
}
