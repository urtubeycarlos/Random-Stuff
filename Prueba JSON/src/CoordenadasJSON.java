import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CoordenadasJSON implements Iterator {

	ArrayList<Coordenada> _coordenadas;
	
	public CoordenadasJSON(){
		_coordenadas = new ArrayList<Coordenada>();
	}
	
	public boolean addCoord(Coordenada c){
		return _coordenadas.add(c);
	}
	
	public int tamanio(){
		return _coordenadas.size();
	}
	
	public Coordenada dame(int i){
		return _coordenadas.get(i);
	}
	
	
	public void generarJSON(String archivo){
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		try {
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static CoordenadasJSON leerJSON(String archivo){
		Gson gson = new Gson();
		CoordenadasJSON ret = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(reader, CoordenadasJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	public Iterable<Coordenada> getIterable(){
		return _coordenadas;
	}
	
	//TODO: Programar!
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	//TODO: Programar!
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

}
