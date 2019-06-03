package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadPorcentual extends Durabilidad {

	private BigDecimal porcentajeAReducir;

	public DurabilidadPorcentual(BigDecimal valorInicial, BigDecimal porcentajeAReducir) {
		super(valorInicial);
		this.porcentajeAReducir = porcentajeAReducir;
	}

	public void reducir(){
		valor = valor.subtract(valor.divide(porcentajeAReducir));
	}
}