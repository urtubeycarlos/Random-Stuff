
public class Coordenada {

	private String _nombre;
	private double _latitud;
	private double _longitud;
	
	public Coordenada(String n, double lat, double lon){
		_nombre = n;
		_latitud = lat;
		_longitud = lon;
	}
	
	public String getNombre(){
		return _nombre;
	}
	
	public double getLatitud(){
		return _latitud;
	}
	
	public double getLongitud(){
		return _longitud;
	}
	
}
