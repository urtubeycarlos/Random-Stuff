import java.util.Comparator;

public abstract class Comparador implements Comparator<Objeto> {

	public static Comparador POR_ID = new Comparador(){

		@Override
		public int compare(Objeto arg0, Objeto arg1){
			return arg0.getID() - arg1.getID();
		}
		
	};
	
	public static Comparador POR_PESO = new Comparador(){
		
		@Override
		public int compare(Objeto arg0, Objeto arg1){
			return (int) ( arg0.getPeso() - arg1.getPeso() );
		}
		
	};
	
	public static Comparador POR_BENEFICIO = new Comparador(){
		
		@Override
		public int compare(Objeto arg0, Objeto arg1){
			return (int) ( arg0.getBeneficio() - arg1.getBeneficio() );
		}
		
	};
	
	
}
