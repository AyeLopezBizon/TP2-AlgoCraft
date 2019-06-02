package fiuba.algo3.tp2.integracion.entrega1;
/*
public class HerramientaTest {

	//Pruebas Hacha de madera
	@Test
	public void dadaUnHachaDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
		Herramienta hacha = new Hacha(new MaderaHerramienta());
		assertTrue(hacha.getDurabilidad()==100);
		assertTrue(hacha.getFuerza()==2);
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDisminuirLaDurabilidadEn2(){
		Herramienta hacha = new Hacha(new MaderaHerramienta());
		Material maderaCubo = new Madera();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(maderaCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraPiedraCubo_DeberiaDisminuirLaDurabilidadEn2(){

		Herramienta hacha = new Hacha(new MaderaHerramienta());
		Material piedraCubo = new PiedraCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(piedraCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraMetalCubo_DeberiaDisminuirLaDurabilidadEn2(){
		Herramienta hacha = new Hacha(new MaderaHerramienta());
		Material metalCubo = new MetalCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(metalCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadaUnHachaDeMadera_CuandoSeUsaUnaVezContraDiamanteCubo_DeberiaDisminuirLaDurabilidadEn2(){
		Herramienta hacha = new Hacha(new MaderaHerramienta());
		Material diamanteCubo = new DiamanteCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(diamanteCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 2, 0.0);
	}

	//Pruebas Pico de madera
	@Test
	public void dadoUnPicoDeMadera_CuandoSeCrea_DeberiaTenerDurabilidad100YFuerza2() {
		Herramienta pico = new Pico(new MaderaHerramienta());
		assertTrue(pico.getDurabilidad()==100);
		assertTrue(pico.getFuerza()==2);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDisminuirLaDurabilidadEn2(){
		Herramienta pico = new Pico(new MaderaHerramienta());
		Material maderaCubo = new Madera();

		float durabilidad = pico.getDurabilidad();

		pico.golpear(maderaCubo);

		assertEquals(pico.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraPiedraCubo_DeberiaDisminuirLaDurabilidadEn2(){

		Herramienta pico = new Pico(new MaderaHerramienta());
		Material piedraCubo = new PiedraCubo();

		float durabilidad = pico.getDurabilidad();

		pico.golpear(piedraCubo);

		assertEquals(pico.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMetalCubo_DeberiaDisminuirLaDurabilidadEn2(){

		Herramienta pico = new Pico(new MaderaHerramienta());
		Material metalCubo = new MetalCubo();

		float durabilidad = pico.getDurabilidad();

		pico.golpear(metalCubo);

		assertEquals(pico.getDurabilidad(), durabilidad - 2, 0.0);
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraDiamanteCubo_DeberiaDisminuirLaDurabilidadEn2(){

		Herramienta pico = new Pico(new MaderaHerramienta());
		Material diamanteCubo = new DiamanteCubo();

		float durabilidad = pico.getDurabilidad();

		pico.golpear(diamanteCubo);

		assertEquals(pico.getDurabilidad(), durabilidad - 2, 0.0);
	}

	//Pruebas Hacha de piedra
	@Test
	public void dadaUnHachaDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza5() {
		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		assertTrue(hacha.getDurabilidad()==200);
		assertTrue(hacha.getFuerza()==5);
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDisminuirLaDurabilidadEn5(){
		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		Material maderaCubo = new Madera();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(maderaCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 5, 0.0);
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraPiedraCubo_DeberiaDisminuirLaDurabilidadEn5(){

		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		Material piedraCubo = new PiedraCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(piedraCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 5, 0.0);
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraMetalCubo_DeberiaDisminuirLaDurabilidadEn5(){
		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		Material metalCubo = new MetalCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(metalCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 5, 0.0);
	}

	@Test
	public void dadaUnHachaDePiedra_CuandoSeUsaUnaVezContraDiamanteCubo_DeberiaDisminuirLaDurabilidadEn5(){
		Herramienta hacha = new Hacha(new PiedraHerramienta(5));
		Material diamanteCubo = new DiamanteCubo();

		float durabilidad = hacha.getDurabilidad();

		hacha.golpear(diamanteCubo);

		assertEquals(hacha.getDurabilidad(), durabilidad - 5, 0.0);
	}

	//Pruebas Pico de piedra
	@Test
	public void dadoUnPicoDePiedra_CuandoSeCrea_DeberiaTenerDurabilidad200YFuerza4(){
		Herramienta pico = new Pico(new PiedraHerramienta(4));
		assertTrue(pico.getDurabilidad()==200);
		assertTrue(pico.getFuerza()==4);
	}
	*/
/*
	@Test
	public void dadoUnPicodePiedra_CuandoSeUsaUnaVezContraMaderaCubo_DeberiaDesminuirlaDurabilidadEn2Coma6(){
		Herramienta pico = new Pico(new Piedra(4));
		MaterialCubo maderaCubo = new MaderaCubo();

		float durabilidad = pico.getDurabilidad();

		pico.usar(maderaCubo);

		assertTrue(pico.getDurabilidad() == (durabilidad - 2.6666f));

	}
*/
	/*
	//Pruebas Hacha de metal
	@Test
	public void dadaUnHachaDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza10() {
		Herramienta hacha = new Hacha(new MetalHerramienta());
		assertTrue(hacha.getDurabilidad()==400);
		assertTrue(hacha.getFuerza()==10);
	}

	//Pruebas Pico de metal
	@Test
	public void dadoUnPicoDeMetal_CuandoSeCrea_DeberiaTenerDurabilidad400YFuerza12() {
		Herramienta pico = new Pico(new MetalHerramienta());
		assertTrue(pico.getDurabilidad()==400);
		assertTrue(pico.getFuerza()==12);
	}

	//Pruebas Pico fino
	@Test
	public void dadoUnPicoFino_CuandoSeCrea_DeberiaTenerDurabilidad1000YFuerza20() {
		Herramienta picoFino = new PicoFino(new MetalHerramienta());
		assertTrue(picoFino.getDurabilidad()==1000);
		assertTrue(picoFino.getFuerza()==20);
	}
	
}
*/