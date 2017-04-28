package mochila;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstanciaTest
{
	@Test(expected = IllegalArgumentException.class)
	public void capacidadNegativaTest()
	{
		new Instancia(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void capacidadNulaTest()
	{
		new Instancia(0);
	}
	
	@Test
	public void tamañoVacioTest()
	{
		Instancia instancia = new Instancia(3);
		assertEquals(0, instancia.tamaño());
	}
	
	@Test
	public void tamañoUnitarioTest()
	{
		Instancia instancia = new Instancia(3);
		instancia.agregar(new Objeto("obj", 1, 1));
		assertEquals(1, instancia.tamaño());
	}

	@Test(expected = IllegalArgumentException.class)
	public void indiceNegativoTest()
	{
		Instancia instancia = new Instancia(5);
		instancia.getObjeto(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void indiceExcedidoTest()
	{
		Instancia instancia = new Instancia(5);
		instancia.agregar(new Objeto("obj", 1, 2));
		instancia.getObjeto(1);
	}

	@Test
	public void getObjetoTest()
	{
		Instancia instancia = new Instancia(5);

		Objeto primero = new Objeto("obj1", 2, 3);
		Objeto segundo = new Objeto("obj2", 1, 2);
		instancia.agregar(primero);
		instancia.agregar(segundo);
		
		assertEquals(primero, instancia.getObjeto(0));
	}
}

