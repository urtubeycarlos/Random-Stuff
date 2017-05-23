package mochila;

public class GeneradorPrefijado implements Generador {

	private boolean[] _booleanos;
	private int _entero;
	private int _indice;
	
	public GeneradorPrefijado(boolean[] booleanosPrefijados, int enteroPrefijado){

		_booleanos = booleanosPrefijados;
		_entero = enteroPrefijado;
		_indice = 0;
		
	}
	
	@Override
	public boolean nextBoolean() {
		return _booleanos[_indice++];
	}

	@Override
	public int nextInt(int limite) {
		return _entero;
	}

}
