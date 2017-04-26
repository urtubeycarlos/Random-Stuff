import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CoordenadasJSON {

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
}
