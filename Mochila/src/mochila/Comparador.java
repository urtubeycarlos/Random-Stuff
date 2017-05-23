package mochila;

import java.util.Comparator;

public class Comparador 
{
	public static Comparator<Objeto> porBeneficio()
	{
		Comparator<Objeto> ret = new Comparator<Objeto>()
		{
			@Override
			public int compare(Objeto uno, Objeto otro) {
				return (int)(otro.getBeneficio() - uno.getBeneficio());
			}};
		return ret;
	}
	
	public static Comparator<Objeto> porCociente()
	{
		Comparator<Objeto> ret = new Comparator<Objeto>()
		{
			@Override
			public int compare(Objeto uno, Objeto otro) 
			{
				return (int)(otro.getCociente() - uno.getCociente());
			}};
		return ret;
	}
	
	public static Comparator<Objeto> porPeso()
	{
		Comparator<Objeto> ret = new Comparator<Objeto>()
		{
			@Override
			public int compare(Objeto uno, Objeto otro)
			{
				return (int)(uno.getPeso() - otro.getPeso());
			}
		};
		return ret;
	}
}

