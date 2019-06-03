package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadRupturaAbrupta extends Durabilidad {

	private Integer usos;
	private BigDecimal tasaDesgaste;

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, BigDecimal tasaDesgaste, Integer cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
		this.tasaDesgaste = tasaDesgaste;
		this.usos = cantidadDeUsosAntesDeRuptura;
	}

	public void reducir() {
		this.usos -= 1;
		this.valor = this.valor.subtract(this.tasaDesgaste);

		if (this.usos <= 0)
			this.valor = new BigDecimal(0);
	}
}