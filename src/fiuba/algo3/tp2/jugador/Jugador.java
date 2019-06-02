package fiuba.algo3.tp2.jugador;

<<<<<<< HEAD
=======
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a
import java.math.BigDecimal;

public class Jugador {

    private Inventario inventario = new Inventario();

    public Jugador() {
        this.inventario.crearHachaDeMadera();
    }

    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.inventario.getDurabilidadDelHachaDeMadera();
    }

    public void golpearConHachaDeMadera(Material material) {
        try {
            this.inventario.golpearConHachaDeMadera(material);
        } catch (MaterialDestruidoNoSePuedeGolpearException e) {
            this.inventario.recoger(material);
        }
    }
}