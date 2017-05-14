package matriz;

import java.util.ArrayList;

public class Matriz<E> {

	private ArrayList<ArrayList<E>> _m;
	
	public Matriz(int ancho, int alto){
		_m = inicializarMatriz(ancho, alto);
	}
	
	public E get(int fila, int columna){
		checkearCoordenada(fila, columna);
		return _m.get(fila).get(columna);
	}
	
	public void set(E e, int fila, int columna){
		checkearCoordenada(fila, columna);
		_m.get(fila).set(columna, e);
	}
	
	public int alto(){
		return _m.size();
	}
	
	public int ancho(){
		return _m.get(0).size();
	}
	
	public int dimension(){
		return _m.size()*_m.get(0).size();
	}
	
	public void redimensionar(int ancho, int alto){
		
		ArrayList<ArrayList<E>> nueva_matriz = inicializarMatriz(ancho, alto);
		
		for(int i=0; i<_m.size(); i++)
		for(int j=0; j<_m.get(i).size(); j++)
			nueva_matriz.get(i).set(j, _m.get(i).get(j));
		
		_m = nueva_matriz;
		
	}
	
	private ArrayList<ArrayList<E>> inicializarMatriz(int ancho, int alto){
		
		ArrayList<ArrayList<E>> lista = new ArrayList<ArrayList<E>>();
		for(int i=0; i<ancho; i++){
			ArrayList<E> aux = new ArrayList<E>();
			for(int j=0; j<alto; j++){
				aux.add(null);
			}
			
			lista.add(aux);
		}
		
		return lista;
	}
	
	private void checkearCoordenada(int i, int j){
		if( i<0 || i>_m.size() )
			throw new IllegalArgumentException("Se intento acceder a una posicion invalida de la matriz. fila = " + i);
		if( j<0 || j>_m.get(0).size() )
			throw new IllegalArgumentException("Se intento acceder a una posicion invalida de la matriz. columna = " + j);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Matriz:\n");
		for(ArrayList<E> a:_m)
			sb.append( a.toString() ).append("\n");
		return sb.toString();
	}
	
	public static void main(String[] args){
		Matriz<Integer> m = new Matriz<Integer>(5, 5);
		m.set(18792, 3, 2);
		System.out.println(m);
		System.out.println(m.get(3, 2));
		m.redimensionar(7, 7);
		System.out.println(m);
	}
	
}
