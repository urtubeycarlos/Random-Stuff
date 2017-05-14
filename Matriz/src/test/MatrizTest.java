package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import matriz.Matriz;

public class MatrizTest {

	Matriz<String> m;
	
	@Before
	public void inicializar(){
		m = new Matriz<String>(3, 3);
		m.set("Carlos", 2, 1);
		m.set("Sebas", 1, 2);
		m.set("Juan", 2, 2);
	}
	
	@Test
	public void dimensionTest(){
		assertEquals(9, m.dimension());
	}
	
	@Test
	public void getAndSetTest() {
		assertEquals("Sebas", m.get(1, 2));
	}

}
