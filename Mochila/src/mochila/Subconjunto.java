package mochila;

import java.util.ArrayList;

public class Subconjunto
{
	private ArrayList<Objeto> _objetos;

	public Subconjunto()
	{
		_objetos = new ArrayList<Objeto>();
	}
	
	public void agregar(Objeto objeto)
	{
		if( _objetos.contains(objeto) )
			throw new IllegalArgumentException("Se intento agregar un objeto que ya esta en el subconjunto! objeto.nombre = " + objeto.getNombre());

		_objetos.add(objeto);
	}
	
	public void eliminar(Objeto objeto)
	{
		if( !_objetos.contains(objeto) )
			throw new IllegalArgumentException("Se intento eliminar un objeto que no esta en el subconjunto! objeto.nombre = " + objeto.getNombre());

		_objetos.remove(objeto);
	}

	public ArrayList<Objeto> getObjetos()
	{
		return _objetos;
	}

	public double beneficio()
	{
		double ret = 0;
		for(Objeto objeto: _objetos)
			ret += objeto.getBeneficio();
		
		return ret;
	}

	public double peso()
	{
		double ret = 0;
		for(Objeto objeto: _objetos)
			ret += objeto.getPeso();
		
		return ret;
	}

	public Subconjunto clonar()
	{
		Subconjunto ret = new Subconjunto();
		for(Objeto objeto: getObjetos())
			ret.agregar(objeto);

		return ret;
	}
}

