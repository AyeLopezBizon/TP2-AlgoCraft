package fiuba.algo3.tp2.vista.sonido;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class ReproductorSonido {
	
	private static Map<String, MediaPlayer> sonidos;
	private static boolean silenciado = false;
	
	public static void cargar() {
		
		sonidos = new HashMap<String, MediaPlayer>();
		/*
		sonidos.put("GOLPE_MATERIAL", newMediaPlayer("src/fiuba/algo3/tp2/vista/resources/sonidos/Golpear.m4a"));
		sonidos.put("RECOGER_UNIDAD_MATERIAL", newMediaPlayer("src/fiuba/algo3/tp2/vista/resources/sonidos/RecogerUnidadMaterial.m4a"));
		sonidos.put("MOVER", newMediaPlayer("src/fiuba/algo3/tp2/vista/resources/sonidos/Mover.m4a"));
		sonidos.put("CLICK", newMediaPlayer("src/fiuba/algo3/tp2/vista/resources/sonidos/Click.m4a"));
		 */
	}
	
	public static void reproducir(String sonido) {
		
		if(!silenciado) {
			MediaPlayer mediaPlayer = sonidos.get(sonido);
			
			if(mediaPlayer != null) {
				
				mediaPlayer.stop();
				mediaPlayer.play();
			}
		}
	}
	
	public static void silenciar(boolean valor) {
		silenciado = valor;
	}
	
	private static MediaPlayer newMediaPlayer(String sonido) {
		
		return new MediaPlayer(new Media(new File(sonido).toURI().toString()));
	}
}
