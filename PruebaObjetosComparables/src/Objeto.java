
public class Objeto {

	private int _id;
	private double _peso;
	private double _beneficio;
	
	public Objeto(int id, double largo, double ancho){
		_id = id;
		_peso = largo;
		_beneficio = ancho;
	}

	public int getID() {
		return _id;
	}

	public double getPeso() {
		return _peso;
	}

	public double getBeneficio() {
		return _beneficio;
	}
	
	@Override
	public String toString(){
		return new String("Objeto: [ id:" + _id + "; peso: " + _peso + "; beneficio: " + _beneficio + "]");
	}
	
}
