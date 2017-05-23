package mochila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividuoTest {

	private Instancia _instancia;

	@Before
	public void inicializar(){
		
		_instancia = new Instancia(10);
		_instancia.agregar( new Objeto("obj1", 4, 7) );
		_instancia.agregar( new Objeto("obj2", 7, 4) );
		_instancia.agregar( new Objeto("obj3", 9, 6) );
		_instancia.agregar( new Objeto("obj4", 2, 4) );
		_instancia.agregar( new Objeto("obj5", 1, 1) );
		
	}
	
	@Test
	public void mutarPrimeroTest() {
		testearMutacion("01100", 0, "11100");
	}
	
	@Test
	public void mutarVerdaderoTest(){
		testearMutacion("11111", 3, "11101");
//		testear( "M(11101, 2) = 11001" );  Hacer!!!
	}
	
	@Test
	public void recombinarTest(){
		testearRecombinacion("11010", "00011", 2, "11011", "00010");
		testearRecombinacion("11011", "00011", 4, "11011", "10011");
	}
	
	private void testearMutacion(String original, int bit, String mutados){
		
		GeneradorPrefijado generador = new GeneradorPrefijado(convertir(original), bit);
		
		Individuo.setGenerador(generador);
		Individuo individuo = new Individuo(_instancia);
		individuo.mutar();
		
		boolean[] bitsResultado = convertir(mutados);
		for( int i=0; i<mutados.length(); i++)
			assertEquals(bitsResultado[i], individuo.get(i));
		
	}
	
	public void testearRecombinacion( String padre1, String padre2, int punto, String hijo1, String hijo2 ){
		
		GeneradorPrefijado generador = new GeneradorPrefijado( convertir(padre1+padre2+"0000000000"), punto );
		Individuo.setGenerador(generador);
		
		Individuo padre = new Individuo(_instancia);
		Individuo madre = new Individuo(_instancia);
		
		Individuo[] hijos = padre.recombinar(madre);
		
		assertIguales(hijo1, hijos[0]);
		assertIguales(hijo2, hijos[1]);		

	}

	private boolean[] convertir(String bits){
		boolean[] ret = new boolean[ bits.length() ];
		for( int i=0; i<bits.length(); i++ )
			ret[i] = bits.charAt(i) == '1';
		return ret;
	}
	

	public void assertIguales(String mutado, Individuo individuo){
		boolean[] convertido = convertir(mutado);
	}
	
}
