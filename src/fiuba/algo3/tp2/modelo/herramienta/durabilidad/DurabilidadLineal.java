package fiuba.algo3.tp2.modelo.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal extends Durabilidad {

	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(BigDecimal valorInicial, BigDecimal tasaDesgaste) {
		super(valorInicial);
		this.tasaDesgaste = tasaDesgaste;
	}

	public void reducir() throws DurabilidadDesgastadaNoSePuedeReducirException {
		if(this.valor.equals(new BigDecimal(0)))
			throw new DurabilidadDesgastadaNoSePuedeReducirException();

		this.valor = this.valor.subtract(this.tasaDesgaste);
	}
}

