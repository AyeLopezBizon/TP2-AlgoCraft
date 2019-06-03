package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadRupturaAbrupta extends Durabilidad {

	private BigDecimal usos;

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, BigDecimal cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
		usos = cantidadDeUsosAntesDeRuptura;
	}

	public void reducir() {
		usos = usos.subtract(new BigDecimal(1));

		if(usos.compareTo(new BigDecimal(0)) <= 0){
			this.valor = new BigDecimal(0);
		}
	}
}