package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadRupturaAbrupta extends Durabilidad {

	private Integer usos;

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, Integer cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
		this.usos = cantidadDeUsosAntesDeRuptura;
	}

	public void reducir() {
		this.usos -= 1;

		if (this.usos <= 0)
			this.valor = new BigDecimal(0);
	}
}