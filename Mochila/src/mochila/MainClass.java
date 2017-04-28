package mochila;

import java.util.Random;

public class MainClass
{
	public static void main(String[] args)
	{
		for(int n=1; n<30; ++n)
		{
			Solver solver = new Solver(aleatoria(n));
			solver.resolver();
		
			System.out.print("n = " + n + " - ");
			System.out.println("Tiempo: " + solver.getTiempo() + " seg");
		}
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