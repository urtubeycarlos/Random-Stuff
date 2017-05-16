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

		HashMap<E, Double> distancias = new HashMap<E, Double>();
		for( E vertice:super.getVertices() )
			distancias.put(vertice, Double.POSITIVE_INFINITY);
		distancias.put(origen, 0.0);
		
		List<E> camino_actual = new ArrayList<E>();
		Set<E> visitados = new HashSet<E>();
		
		while( !visitados.contains(destino) ){
			
			nodo_actual = obtenerMenor(distancias, visitados);
			visitados.add(nodo_actual);
			camino_actual.add(nodo_actual);

			for( E nodo_j:super.getVecinos(nodo_actual) ) if( !visitados.contains(nodo_j) ){
				Double calc_distancia = distancias.get(nodo_actual) + getPeso(nodo_actual, nodo_j);
				if ( calc_distancia < distancias.get(nodo_j) ){
					distancias.put(nodo_j, calc_distancia);
				}
			}
		}

		if( !camino_actual.contains(destino) )
			return null;

		for( int i=1; i<camino_actual.size()-1; i++ ){
			
			E anterior = camino_actual.get(i-1);
			E siguiente = camino_actual.get(i+1);
			E actual = camino_actual.get(i);
			
			if( existeArista(anterior, siguiente) ){
				double peso_ant_sig = getPeso(anterior, siguiente);
				double peso_ant_act_sig = peso_ant_sig + getPeso(actual, siguiente);
				
				if( peso_ant_sig <= peso_ant_act_sig )
					camino_actual.remove(actual);
			}
			
		}
		
		return camino_actual;
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
	
	//FIXME: URGENTE! Hacer que el resultado de toString() sea mas lindo.
	@Override
	public String toString(){
		String ret = new String();
		ret += ("Grafo: {");
		for( E vertice:getVertices() ){
			ret += vertice.toString() + ": [";
			for( E vecino:getVecinos(vertice) )
				ret += vecino.toString() + ", ";
			ret += ("]; ");
		} return ret += ("}");
	}
	
	public static void main(String[] args){
		GrafoPesadoUnidireccional<Integer> g = new GrafoPesadoUnidireccional<>();
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		
		g.agregarArista(1, 2, 5.0);
		g.agregarArista(2, 3, 5.0);
		g.agregarArista(1, 3, 7.0);

		System.out.println(g);
		
		System.out.println( g.obtenerCaminoMinimo(1, 3) );
		
	}
	
}
