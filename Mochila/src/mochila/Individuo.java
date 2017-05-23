package mochila;

public class Individuo {
	
	//Un individuo se representa por una secuencia de  bits, uno por cada objeto.
	private boolean[] _bits;

	//El generador de números aleatorios es static para usar un unico generador.
	private static Generador _generador = null;
	

	//Seter para el generador aleatorio
	public static void setGenerador(Generador generador){
		_generador = generador;
	}
	
	//Los nuevos individuos se generan de manera aleatoria.
	public  Individuo( Instancia instancia ){
		_bits = new boolean[ instancia.tamaño() ];
		for( int i=0; i<_bits.length; i++ )
			_bits[i] = _generador.nextBoolean();
	}
	
	//Mutacion del individuo: seleecionamos un bit aleatoriamente y lo cambiamos.
	public void mutar(){
		int i = _generador.nextInt( _bits.length );
		_bits[i] = !_bits[i];
	}
	
}
