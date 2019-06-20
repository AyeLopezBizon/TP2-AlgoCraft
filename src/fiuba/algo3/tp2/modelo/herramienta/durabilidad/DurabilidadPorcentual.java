package fiuba.algo3.tp2.modelo.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadPorcentual extends Durabilidad {

	private BigDecimal porcentajeAReducir;

	public DurabilidadPorcentual(BigDecimal valorInicial, BigDecimal porcentajeAReducir) {
		super(valorInicial);
		this.porcentajeAReducir = porcentajeAReducir;
	}

	public void reducir() throws DurabilidadDesgastadaNoSePuedeReducirException {
		if(this.valor.equals(new BigDecimal(0)))
			throw new DurabilidadDesgastadaNoSePuedeReducirException();

		this.valor = this.valor.subtract(this.valor.divide(this.porcentajeAReducir));
	}
}