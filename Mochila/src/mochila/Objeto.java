package mochila;

public class Objeto
{
	private String _nombre;
	private double _peso;
	private double _beneficio;
	
	public Objeto(String nombre, double peso, double beneficio)
	{
		_nombre = nombre;
		_peso = peso;
		_beneficio = beneficio;
	}

	public String getNombre()
	{
		return _nombre;
	}

	public double getPeso()
	{
		return _peso;
	}

	public double getBeneficio()
	{
		return _beneficio;
	}

	
	public double getCociente()
	{
		return _peso > 0 ? _beneficio / _peso : Double.POSITIVE_INFINITY;
	}
}
