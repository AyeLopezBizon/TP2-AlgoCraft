package fiuba.algo3.tp2.jugador;

import java.math.BigDecimal;

public class Jugador {

    private Inventario inventario = new Inventario();;

    public Jugador() {
        this.inventario.crearHachaDeMadera();
    }

    public BigDecimal getDurabilidadDelHachaDeMadera() {
        return this.inventario.getDurabilidadDelHachaDeMadera();
    }
}
