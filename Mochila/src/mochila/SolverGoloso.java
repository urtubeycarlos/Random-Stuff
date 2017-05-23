package mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolverGoloso
{
	private Instancia _instancia;
	private Comparator<Objeto> _comparador;
	
	public SolverGoloso(Instancia instancia, Comparator<Objeto> comparador)
	{
		_instancia = instancia;
		_comparador = comparador;
	}
	
	public Subconjunto resolver()
	{
		ArrayList<Objeto> ordenados = ordenarObjetos();
		return construirSolucion(ordenados);
	}

	private ArrayList<Objeto> ordenarObjetos()
	{
		ArrayList<Objeto> objetos = _instancia.getObjetos();
		Collections.sort(objetos, _comparador);
		
		return objetos;
	}

	private Subconjunto construirSolucion(ArrayList<Objeto> ordenados)
	{
		Subconjunto ret = new Subconjunto();
		for(Objeto objeto: ordenados)
		{
			if( ret.peso() + objeto.getPeso() <= _instancia.getCapacidad() )
				ret.agregar(objeto);
		}
		
		return ret;
	}
}
