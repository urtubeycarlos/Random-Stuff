package mochila;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverTest
{
	@Test
	public void instanciaVaciaTest()
	{
		Instancia vacia = new Instancia(3);
		Solver solver = new Solver(vacia);
		Subconjunto solucion = solver.resolver();
		
		assertEquals(0, solucion.getObjetos().size());
	}
	
	@Test
	public void tresObjetosTest()
	{
		Solver solver = new Solver(peque�a(4));
		Subconjunto solucion = solver.resolver();
		
		assertEquals(31, solucion.beneficio(), 1e-5);
	}
	
	@Test
	public void ningunObjetoTest()
	{
		Solver solver = new Solver(peque�a(0.5));
		Subconjunto solucion = solver.resolver();
		
		assertEquals(0, solucion.beneficio(), 1e-5);
	}
	
	@Test
	public void entranTodosTest()
	{
		Solver solver = new Solver(peque�a(6));
		Subconjunto solucion = solver.resolver();
		
		assertEquals(41, solucion.beneficio(), 1e-5);
	}

	private Instancia peque�a(double capacidad)
	{
		Instancia instancia = new Instancia(capacidad);
		instancia.agregar(new Objeto("A", 1, 11));
		instancia.agregar(new Objeto("B", 2, 20));
		instancia.agregar(new Objeto("C", 3, 10));
		return instancia;
	}
	
	@Test
	public void unObjetoTest()
	{
		Instancia instancia = new Instancia(100);
		instancia.agregar(new Objeto("A", 0, 1));
		
		Solver solver = new Solver(instancia);
		Subconjunto solucion = solver.resolver();
		
		assertEquals(1, solucion.getObjetos().size());
	}
}
