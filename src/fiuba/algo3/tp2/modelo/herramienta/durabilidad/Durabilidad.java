package fiuba.algo3.tp2.modelo.herramienta.durabilidad;

import java.math.BigDecimal;

public abstract class Durabilidad {

	protected BigDecimal valor;
	protected BigDecimal maximoValor;

	public Durabilidad(BigDecimal valorInicial) {
		this.valor = valorInicial;
		this.maximoValor = valorInicial;
	}

	public BigDecimal getValor() {
		return this.valor;
	}
	
	public BigDecimal getMaximoValor() {
		return this.maximoValor;
	}

	public abstract void reducir() throws DurabilidadDesgastadaNoSePuedeReducirException;
}
