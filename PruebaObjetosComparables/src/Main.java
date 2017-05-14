import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		Objeto[] objs = new Objeto[]{
				new Objeto(5, 2.0, 800.0),
				new Objeto(3, 18.0, 1000.0),
				new Objeto(7, 50.0, 400.0)
		};
		
		ArrayList<Objeto> lista = new ArrayList<Objeto>();
		lista.addAll( Arrays.asList(objs) );

		Collections.sort(lista, Comparador.POR_ID);
		System.out.println(lista);
		
		Collections.sort(lista, Comparador.POR_PESO);
		System.out.println(lista);
		
		Collections.sort(lista, Comparador.POR_BENEFICIO);
		System.out.println(lista);
		

		Comparador comparador_personalizado = new Comparador(){

			@Override
			public int compare(Objeto o1, Objeto o2) {
				double prom_o1 = o1.getBeneficio()/o1.getPeso();
				double prom_02 = o2.getBeneficio()/o2.getPeso();
				
				return (int) (prom_o1 - prom_02);
				
			}
			
		};
		
		Collections.sort(lista, comparador_personalizado);
		System.out.println(lista);
		
	}

}
