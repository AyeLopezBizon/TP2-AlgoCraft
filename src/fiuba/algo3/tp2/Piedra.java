package fiuba.algo3.tp2;

public class Piedra extends Material {
    private int fuerza;
    private float durabilidad = 200;

    public Piedra(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public float getDurabilidad(Herramienta herramienta) {
        return durabilidad;
    }

    @Override
    public int getFuerza(Herramienta herramienta) {
        return fuerza;
    }

    @Override
    public void reducirDurabilidad(Herramienta herramienta, MaterialCubo materialCubo) {
        durabilidad -= (fuerza);
    }
}
