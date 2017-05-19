package ejemplo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Persona> lista_personas = new ArrayList<Persona>();
		Persona[] personas = new Persona[]{
			new Persona("Ana", "Maria", 15),
			new Persona("Carlos", "Urtubey", 22),
			new Persona("Sebastian", "Posadas", 21)
		};
		
		lista_personas.addAll( Arrays.asList(personas) );
		
		Persona.aplicar( lista_personas, p -> System.out.println("Nombre: " + p.nombre() + "; Apellido: " + p.apellido() + "; Edad: " + p.edad() ) );
		System.out.println( Persona.filtrar( lista_personas , p -> p.edad() >= 18 ) );
		
		Persona.calcular(lista_personas, p -> p.edad() / 3.0);
		Collections.sort(lista_personas, (p,q) -> { return p.edad() < q.edad() ? 1 : p.edad() == q.edad() ? 0 : -1;});
		
		lista_personas.forEach(p -> System.out.println(p.nombre()));
	}

}
