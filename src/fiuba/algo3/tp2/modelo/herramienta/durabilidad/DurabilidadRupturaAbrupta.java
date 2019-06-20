package fiuba.algo3.tp2.modelo.herramienta.durabilidad;

import java.math.BigDecimal;

public class DurabilidadRupturaAbrupta extends Durabilidad {

	private Integer usos;

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, Integer cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
		this.usos = cantidadDeUsosAntesDeRuptura;
	}

	public void reducir() throws DurabilidadDesgastadaNoSePuedeReducirException {
		if(this.valor.equals(new BigDecimal(0)))
			throw new DurabilidadDesgastadaNoSePuedeReducirException();

		this.usos -= 1;

		if (this.usos <= 0)
			this.valor = new BigDecimal(0);
	}
}