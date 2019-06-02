package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public abstract class Durabilidad {

	protected BigDecimal valor;

	public Durabilidad(BigDecimal valorInicial) {
		this.valor = valorInicial;
	}

	public abstract void reducir();

	public BigDecimal getValor() {
		return this.valor;
	}
<<<<<<< HEAD
}

=======
}
>>>>>>> refs/remotes/origin/develop
