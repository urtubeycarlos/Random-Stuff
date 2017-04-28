package mochila;

import java.util.Random;

import javax.swing.SwingWorker;

public class Worker extends SwingWorker <Boolean, Object> {
	
	private MainForm _padre;
	
	public Worker( MainForm padre){
		_padre = padre;
	}

	@Override
	protected Boolean doInBackground() throws Exception {

		for(int n=1; n<20; ++n)
		{
			Solver solver = new Solver(aleatoria(n));
			solver.resolver();
			_padre.mostrarProgreso(n * 100.0 / 20);
			if( isCancelled() )
				_padre.pausarProceso();
				return true;
		}
		
		return null;
	}
	
	private static Instancia aleatoria(int n)
	{
		Random random = new Random(2);
		Instancia instancia = new Instancia(2*n);
		
		for(int i=0; i<n; ++i)
		{
			int peso = random.nextInt(10);
			int beneficio = random.nextInt(10);

			instancia.agregar(new Objeto("x", peso, beneficio));
		}

		return instancia;
	}
	
}

