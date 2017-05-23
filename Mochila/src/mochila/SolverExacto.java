package mochila;

public class SolverExacto
{
	private Instancia _instancia;
	private Subconjunto _subconjunto;
	private Subconjunto _incumbent;
	private double _tiempo;
	
	public SolverExacto(Instancia instancia)
	{
		_instancia = instancia;
	}
	
	public Subconjunto resolver()
	{
		_subconjunto = new Subconjunto();
		_incumbent = new Subconjunto();
		
		long inicio = System.currentTimeMillis();
		considerar(0);
		long fin = System.currentTimeMillis();
	
		_tiempo = (fin - inicio) / 1000.0;
		return _incumbent;
	}
	
	private void considerar(int indice)
	{
		// Caso base
		if( indice == _instancia.tamaño())
		{
			if( _subconjunto.peso() <= _instancia.getCapacidad() &&
				_subconjunto.beneficio() > _incumbent.beneficio() )
			{
				_incumbent = _subconjunto.clonar();
			}

			return;
		}
		
		_subconjunto.agregar(_instancia.getObjeto(indice));
		considerar(indice+1);

		_subconjunto.eliminar(_instancia.getObjeto(indice));
		considerar(indice+1);
	}
	
	public double getTiempo()
	{
		return _tiempo;
	}
}
