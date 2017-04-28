package mochila;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubconjuntoTest
{
	@Test
	public void beneficioVacioTest()
	{
		Subconjunto vacio = new Subconjunto();
		assertEquals(0, vacio.beneficio(), 1e-5);
	}

	@Test
	public void beneficioTest()
	{
		Subconjunto subconjunto = new Subconjunto();
		subconjunto.agregar(new Objeto("obj1", 5, 2));
		subconjunto.agregar(new Objeto("obj2", 7, 4));
		
		assertEquals(6, subconjunto.beneficio(), 1e-5);
	}

	@Test
	public void pesoTest()
	{
		Subconjunto subconjunto = new Subconjunto();
		subconjunto.agregar(new Objeto("obj1", 5, 2));
		subconjunto.agregar(new Objeto("obj2", 7, 4));
		
		assertEquals(12, subconjunto.peso(), 1e-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eliminarVacioTest()
	{
		Subconjunto subconjunto = new Subconjunto();
		subconjunto.eliminar(new Objeto("obj2", 2, 2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eliminarInexistenteTest()
	{
		Subconjunto subconjunto = new Subconjunto();
		subconjunto.agregar(new Objeto("obj1", 1, 1));
		subconjunto.eliminar(new Objeto("obj2", 2, 2));
	}
	
	@Test
	public void eliminarExistenteTest()
	{
		Objeto obj = new Objeto("obj1", 1, 1);
		
		Subconjunto subconjunto = new Subconjunto();
		subconjunto.agregar(obj);
		subconjunto.eliminar(obj);
		
		assertEquals(0, subconjunto.getObjetos().size());		
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarRepetidoTest()
	{
		Objeto obj = new Objeto("obj1", 1, 1);

		Subconjunto subconjunto = new Subconjunto();
		subconjunto.agregar(obj);
		subconjunto.agregar(obj);
	}
}
