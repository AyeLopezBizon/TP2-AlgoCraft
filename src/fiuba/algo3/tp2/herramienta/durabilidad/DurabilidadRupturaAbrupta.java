package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadRupturaAbrupta extends Durabilidad {

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, BigDecimal cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
	}

	public BigDecimal getValor() {
		return new BigDecimal(0);
	}

	public void reducir() {
		// TODO Auto-generated method stub
	}
}