package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal implements Durabilidad {

	private Integer durabilidadActual;
	private BigDecimal tasaDesgaste;
	

	public DurabilidadLineal(Integer durabilidadInicial, BigDecimal tasaDesgaste) {
		
		this.durabilidadActual = durabilidadInicial;
		this.tasaDesgaste = tasaDesgaste;
	}

	@Override
	public void reducir() {
		Integer tasa = tasaDesgaste.intValue();
		durabilidadActual = durabilidadActual - tasa;
	}

	@Override
	public float getValor() {
		return durabilidadActual;
	}

}
