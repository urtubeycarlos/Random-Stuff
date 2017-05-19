package ejemplo;

import java.util.ArrayList;
import java.util.Arrays;

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
		
	}

}
