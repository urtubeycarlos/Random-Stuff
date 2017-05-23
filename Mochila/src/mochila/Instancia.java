package mochila;

import java.util.ArrayList;

public class Instancia
{
	private double _capacidad;
	private ArrayList<Objeto> _objetos;
	
	public Instancia(double capacidad)
	{
		if( capacidad <= 0 )
			throw new IllegalArgumentException("La capacidad debe ser positiva! capacidad = " + capacidad);
		
		_capacidad = capacidad;
		_objetos = new ArrayList<Objeto>();
	}
	
	public double getCapacidad()
	{
		return _capacidad;
	}
	
	public void agregar(Objeto obj)
	{
		_objetos.add(obj);
	}
	
	public int tamaño()
	{
		return _objetos.size();
	}
	
	public Objeto getObjeto(int i)
	{
		if( i < 0 || i >= tamaño() )
			throw new IllegalArgumentException("Se pidio un objeto de indice erroneo! indice = " + i);
		
		return _objetos.get(i);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Objeto> getObjetos()
	{
		return (ArrayList<Objeto>) _objetos.clone();
	}
}
