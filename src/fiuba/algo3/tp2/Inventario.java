package fiuba.algo3.tp2;

public class Inventario {

    private Hacha hachaDeMadera;

    public void crearHachaDeMadera() {
        this.hachaDeMadera = new Hacha(new Madera());
    }

    public float getDurabilidadDelHachaDeMadera() {
        return this.hachaDeMadera.getDurabilidad();
    }
}