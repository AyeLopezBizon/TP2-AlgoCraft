package fiuba.algo3.tp2.jugador.inventario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;


public class InventarioTest {

    @Test
    public void cuandoSeCreaUnInventarioDe10Espacios_SuCapacidadDeberiaSer10() {
        
    	Inventario inventario = new Inventario(10);
    	
        assertEquals(new Integer(10), inventario.obtenerCapacidad());
    }
    
    @Test
    public void dadoUnInventarioConUnHachaDeMaderaEnElEspacio1_CuandoSeObtieneElAlmacenableDelEspacio1_DeberiaDevolverElHachaDeMadera() 
    		throws Exception {
        
    	Inventario inventario = new Inventario(10);
    	
        Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
        inventario.almacenar(hachaDeMadera);
        
        assertEquals(hachaDeMadera, inventario.obtenerAlmacenable(1));
    }
    
    @Test
    public void dadoUnInventarioCon10Espacios_CuandoSeObtieneElAlmacenableDelEspacio11_DeberiaLanzarEspacioNoEncontradoException() 
    		throws Exception {
        
    	Inventario inventario = new Inventario(10);
        
        try {
        	inventario.obtenerAlmacenable(11);
        	fail("Deberia lanzar EspacioVacioException");
        }catch(Exception e) {
        	assertEquals(EspacioVacioException.class, e.getClass());
        }
    }
    
    @Test
    public void dadoUnInventarioCon10Espacios_CuandoSeObtieneElAlmacenableDelEspacio0_DeberiaLanzarEspacioNoEncontradoException() 
    		throws Exception {
        
    	Inventario inventario = new Inventario(10);
        
        try {
        	inventario.obtenerAlmacenable(0);
        	fail("Deberia lanzar EspacioVacioException");
        }catch(Exception e) {
        	assertEquals(EspacioVacioException.class, e.getClass());
        }
    }
    
    @Test
    public void dadoUnInventarioConUnHachaDeMaderaEnElEspacio1_CuandoSeObtieneElAlmacenableDelEspacio2_DeberiaLanzarEspacioVacioException() 
    		throws Exception {
        
    	Inventario inventario = new Inventario(10);
    	
        Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
        inventario.almacenar(hachaDeMadera);
        
        try {
        	inventario.obtenerAlmacenable(2);
        	fail("Deberia lanzar EspacioVacioException");
        }catch(Exception e) {
        	assertEquals(EspacioVacioException.class, e.getClass());
        }
    }
    
    @Test
    public void dadoUnInventarioLleno_CuandoSeAlmacenaUnHachaDeMadera_DeberiaLanzarInventarioLlenoException() 
    		throws Exception {
        
    	Inventario inventario = new Inventario(2);
    	
        Herramienta hachaDeMadera = HerramientaFactory.newHachaDeMadera();
        inventario.almacenar(hachaDeMadera);
        inventario.almacenar(hachaDeMadera);
        
        try {
        	inventario.almacenar(hachaDeMadera);
        	fail("Deberia lanza InventarioLlenoException");
        }catch(Exception e) {
        	assertEquals(InventarioLlenoException.class, e.getClass());
        }
    }
}