package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import matriz.MatrizRelacional;

public class GrafoPesadoUnidireccional<E> extends GrafoUnidireccional<E> {

	MatrizRelacional<E, Double> _matrizPesos;
	
	public GrafoPesadoUnidireccional(){
		_matrizPesos = new MatrizRelacional<E, Double>();
	}
	
	@Override
	public boolean agregarVertice(E vertice){
		return super.agregarVertice(vertice);
	}
	
	@Override
	public boolean agregarArista(E vertice1, E vertice2){
		return this.agregarArista(vertice1, vertice2, 0.0);
	}
	
	public boolean agregarArista(E vertice1, E vertice2, Double peso){
		_matrizPesos.set(vertice1, vertice2, peso);
		return super.agregarArista(vertice1, vertice2);
	}
	
	public Double getPeso(E vertice1, E vertice2){
		super.checkearArista(vertice1, vertice2, "obtener el peso");
		return _matrizPesos.get(vertice1, vertice2);
	}

	public List<E> obtenerCaminoMinimo(E origen, E destino){

		super.checkearVertice(origen, "obtener un camino minimo");
		super.checkearVertice(destino, "obtener un camino minimo");
		
		E nodo_actual;

		HashMap<E, Double> distancias_tentativas = new HashMap<E, Double>();
		for( E vertice:super.getVertices() )
			distancias_tentativas.put(vertice, Double.POSITIVE_INFINITY);
		distancias_tentativas.put(origen, 0.0);
		
		List<E> ret = new ArrayList<E>();
		Set<E> visitados = new HashSet<E>();
		
		while( !visitados.contains(destino) && !visitados.containsAll( super.getVertices() ) ){
			
			nodo_actual = obtenerMenor(distancias_tentativas, visitados);
			visitados.add(nodo_actual);
			ret.add(nodo_actual);
			
			for( E nodo_j:super.getVecinos(nodo_actual) ) if( !visitados.contains(nodo_j) ){
			
				Double calc_distancia = distancias_tentativas.get(nodo_actual) + getPeso(nodo_actual, nodo_j);
				if ( calc_distancia < distancias_tentativas.get(nodo_j) )
					distancias_tentativas.put(nodo_j, calc_distancia);
			}
			
		}

		if( !ret.contains(destino) )
			return null;
		return ret;
	}
	
	private E obtenerMenor(HashMap<E, Double> dist_tentativas, Set<E> visitados){
		
		E ret = null;
		Double menor_actual = Double.POSITIVE_INFINITY;

		for( Entry<E, Double> entry:dist_tentativas.entrySet() ){
			if( entry.getValue() < menor_actual && !visitados.contains( entry.getKey() ) ){
				menor_actual = entry.getValue();
				ret = entry.getKey();
			}
		}
		
		return ret;
	}
	
}
