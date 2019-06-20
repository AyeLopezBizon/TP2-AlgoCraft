package fiuba.algo3.tp2.modelo.jugador.movimiento;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class MovimientoHaciaDerecha implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.avanzarColumna();
    }
}