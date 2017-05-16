package grafo;

/**
 * @author Bianchini, Posadas, Urtubey
 * 
 * Grafo dirigido donde al agregar una arista (X, Y) se guarda
 * que X esta relacionado con Y e Y esta relacionado con X.
 * 
 * @param <E> Tipo de dato que va a representar cada nodo del grafo.
 */
public class GrafoBidireccional<E> extends GrafoUnidireccional<E>{

	@Override
	public boolean agregarArista(E e1, E e2){
		return super.agregarArista(e1, e2) && super.agregarArista(e2, e1);
	}
	
	@Override
	public boolean eliminarArista(E e1, E e2){
		return super.eliminarArista(e1, e2) && super.eliminarArista(e2, e1);
	}
	
}
