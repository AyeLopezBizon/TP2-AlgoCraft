package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal implements Durabilidad {

	private Integer durabilidadInicial;
	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(Integer durabilidadInicial, BigDecimal tasaDesgaste) {
		
		this.durabilidadInicial = durabilidadInicial;
		this.tasaDesgaste = tasaDesgaste;
	}

	@Override
	public void reducir() {
		// TODO Auto-generated method stub
	}

	@Override
	public float getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
