package fiuba.algo3.tp2.modelo.jugador.movimiento;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class MovimientoHaciaArriba implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.avanzarFila();
    }
}
