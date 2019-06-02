package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;
<<<<<<< HEAD

public interface Durabilidad {
=======
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a

public abstract class Durabilidad {

<<<<<<< HEAD
	BigDecimal getValor();
}
=======
	protected BigDecimal valor;

	public Durabilidad(BigDecimal valorInicial) {
		this.valor = valorInicial;
	}

	public abstract void reducir();

	public BigDecimal getValor() {
		return this.valor;
	}
}
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a
