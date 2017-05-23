package mochila;

public class Individuo {
	
	//Un individuo se representa por una secuencia de  bits, uno por cada objeto.
	private boolean[] _bits;

	//El generador de números aleatorios es static para usar un unico generador.
	private static Generador _random = null;
	
	private Instancia _instancia;

	//Seter para el generador aleatorio
	public static void setGenerador(Generador generador){
		_random = generador;
	}
	
	//Los nuevos individuos se generan de manera aleatoria.
	public  Individuo( Instancia instancia ){
		_bits = new boolean[ instancia.tamaño() ];
		_instancia = instancia;
		for( int i=0; i<_bits.length; i++ )
			_bits[i] = _random.nextBoolean();
	}
	
	//Mutacion del individuo: seleecionamos un bit aleatoriamente y lo cambiamos.
	public void mutar(){
		int i = _random.nextInt( _bits.length );
		_bits[i] = !_bits[i];
	}

	public Individuo[] recombinar(Individuo otro){
		
		Individuo hijo1 = new Individuo(_instancia);
		Individuo hijo2 = new Individuo(_instancia);
		
		int corte  = _random.nextInt( _bits.length );
		
		for( int i=0; i<corte; i++ ){
			hijo1.set(i, this.get(i));
			hijo2.set(i, otro.get(i));
		}
		
		for( int i=corte; i<_bits.length; i++ ){
			hijo1.set(i, otro.get(i));
			hijo2.set(i, this.get(i));
		}
		
		return new Individuo[]{hijo1, hijo2};
	}
	
	boolean get(int i){
		return _bits[i];
	}
	
	void set(int i, boolean bit){
		_bits[i] = bit;
	}
	
}
