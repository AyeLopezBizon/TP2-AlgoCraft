package fiuba.algo3.tp2.jugador;

public class Jugador {

    private Inventario inventario = new Inventario();;

    public Jugador() {
        this.inventario.crearHachaDeMadera();
    }

    public float getDurabilidadDelHachaDeMadera() {
        return this.inventario.getDurabilidadDelHachaDeMadera();
    }
}
