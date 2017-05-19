package ejemplo;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Persona {

	private String _nombre;
	private String _apellido;
	private int _edad;
	
	public Persona(String nombre, String apellido, int edad){
		_nombre = nombre;
		_apellido = apellido;
		_edad = edad;
	}

	public String nombre() {
		return _nombre;
	}

	public String apellido() {
		return _apellido;
	}

	public int edad() {
		return _edad;
	}
	
	@Override
	public String toString(){
		return new String("Nombre: " + nombre() + "; Apellido: " + apellido() +"; Edad: " + edad() );
	}
	
	public static void aplicar(ArrayList<Persona> personas, Consumer<Persona> consumidor){
		for( Persona persona:personas )
			consumidor.accept( persona );
	}
	
	public static ArrayList<Persona> filtrar( ArrayList<Persona> personas, Predicate<Persona> filtro ){
		
		ArrayList<Persona> ret = new ArrayList<Persona>();
		
		for( Persona persona:personas )
			if( filtro.test( persona ) )
				ret.add( persona );
		
		return ret;
			
	}
	
}
