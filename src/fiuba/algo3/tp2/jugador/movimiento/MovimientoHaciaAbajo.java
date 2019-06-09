package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;

public class MovimientoHaciaAbajo implements Movimiento {

    @Override
    public void mover(Posicion posicion) {
        posicion.avanzarFila();
    }
}
