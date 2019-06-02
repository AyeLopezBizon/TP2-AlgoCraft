package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal extends Durabilidad {

<<<<<<< HEAD
	private BigDecimal durabilidadInicial;
	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(BigDecimal durabilidadInicial, BigDecimal tasaDesgaste) {
		
		this.durabilidadInicial = durabilidadInicial;
=======
	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(BigDecimal valorInicial, BigDecimal tasaDesgaste) {
		super(valorInicial);
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a
		this.tasaDesgaste = tasaDesgaste;
	}

	@Override
	public void reducir() {
<<<<<<< HEAD
		durabilidadInicial = durabilidadInicial.subtract(tasaDesgaste);
	}

	@Override
	public BigDecimal getValor() {

		return durabilidadInicial;
	}

}
=======
		this.valor = this.valor.subtract(this.tasaDesgaste);
	}
}
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a
