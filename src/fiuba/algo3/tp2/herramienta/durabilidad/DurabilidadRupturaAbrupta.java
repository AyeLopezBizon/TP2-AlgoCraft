package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;
<<<<<<< HEAD

public class DurabilidadRupturaAbrupta implements Durabilidad {
=======
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a

public class DurabilidadRupturaAbrupta extends Durabilidad {

	public DurabilidadRupturaAbrupta(BigDecimal valorInicial, BigDecimal cantidadDeUsosAntesDeRuptura) {
		super(valorInicial);
	}

	@Override
<<<<<<< HEAD
	public BigDecimal getValor() {
		// TODO Auto-generated method stub
		return new BigDecimal(0);
=======
	public void reducir() {
		// TODO Auto-generated method stub
>>>>>>> 15e87421661bc1613acf3265fc0439b23fc8c36a
	}
}