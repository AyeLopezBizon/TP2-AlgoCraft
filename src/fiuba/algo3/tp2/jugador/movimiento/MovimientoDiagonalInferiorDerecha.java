package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class MovimientoDiagonalInferiorDerecha implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.retrocederFila().avanzarColumna();
    }
}
