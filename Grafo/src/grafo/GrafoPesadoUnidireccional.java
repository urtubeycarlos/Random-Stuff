package grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

		E nodo_actual;
		
		MatrizRelacional<E, Double> distancias_tentativas = new MatrizRelacional<E, Double>();
		distancias_tentativas.set(origen, origen, 0.0);
		for( E vertice:super.getVertices() ){
			distancias_tentativas.set(origen, vertice, Double.POSITIVE_INFINITY);
		}
		
		List<E> ret = new ArrayList<E>();
		Set<E> visitados = new HashSet<E>();
		
		while( !visitados.contains(destino) ){
			
			nodo_actual = obtenerMenor(distancias_tentativas, visitados);
			visitados.add(nodo_actual);
			ret.add(nodo_actual);
			
			for( E nodo_j:super.getVecinos(nodo_actual) ) if( !visitados.contains(nodo_j) ){
			
				Double calc_distancia = distancias_tentativas.get(origen, nodo_actual) + getPeso(nodo_actual, nodo_j);
				if ( calc_distancia < distancias_tentativas.get(origen, nodo_j) )
					distancias_tentativas.set(origen, nodo_j, calc_distancia);
			}
			
		}
		
		return ret;
	}
	
	private E obtenerMenor(MatrizRelacional<E, Double> dist_tentativas, Set<E> visitados){
		
		E ret = null;
		Double menor_actual = Double.POSITIVE_INFINITY;
		
		for( Double dist:dist_tentativas.values() ){
			if( (dist < menor_actual) && !visitados.contains( dist_tentativas.columnOf(menor_actual) ) ){
				menor_actual = dist;
				ret = dist_tentativas.rowOf(menor_actual);
			}
		}
		
		return ret;
		
	}
	
}
