package mochila;

import java.util.Random;

public class GeneradorAleatorio implements Generador {

	Random _random = new Random();
	
	public GeneradorAleatorio(){
		_random = new Random();
	}
	
	@Override
	public boolean nextBoolean(){
		return _random.nextBoolean();
	}
	
	@Override
	public int nextInt(int limite){
		return _random.nextInt(limite);
	}
	
}
