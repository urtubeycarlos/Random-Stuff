package mochila;

import java.util.Random;

public class MainClass
{
	public static void main(String[] args)
	{
		Instancia instancia = aleatoria(20);
		SolverGoloso solver = new SolverGoloso(instancia, Comparador.porBeneficio());
		Subconjunto solucion = solver.resolver();
		
		System.out.println("Beneficio: " + solucion.beneficio());
	}

	private static Instancia aleatoria(int n)
	{
		Random random = new Random(2);
		Instancia instancia = new Instancia(10*n);
		
		for(int i=0; i<n; ++i)
		{
			int peso = random.nextInt(20);
			int beneficio = random.nextInt(10);

			instancia.agregar(new Objeto("x", peso, beneficio));
		}

		return instancia;
	}
}
