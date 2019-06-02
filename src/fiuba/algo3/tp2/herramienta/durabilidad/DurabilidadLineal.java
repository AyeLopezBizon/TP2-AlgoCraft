package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal implements Durabilidad {

	private BigDecimal durabilidadInicial;
	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(BigDecimal durabilidadInicial, BigDecimal tasaDesgaste) {
		
		this.durabilidadInicial = durabilidadInicial;
		this.tasaDesgaste = tasaDesgaste;
	}

	@Override
	public void reducir() {
		durabilidadInicial = durabilidadInicial.subtract(tasaDesgaste);
	}

	@Override
	public BigDecimal getValor() {

		return durabilidadInicial;
	}

}
