package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadLineal extends Durabilidad {

	private BigDecimal tasaDesgaste;

	public DurabilidadLineal(BigDecimal valorInicial, BigDecimal tasaDesgaste) {
		super(valorInicial);
		this.tasaDesgaste = tasaDesgaste;
	}

	@Override
	public void reducir() {
<<<<<<< HEAD

		this.valor = this.valor.subtract(this.tasaDesgaste);
	}
}
=======
		this.valor = this.valor.subtract(this.tasaDesgaste);
	}
}
>>>>>>> refs/remotes/origin/develop
