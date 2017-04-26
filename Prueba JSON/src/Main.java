
public class Main {

	public static void main(String[] args) {

		Coordenada coord1 = new Coordenada("Casa", -34.2134, -54.325);
		Coordenada coord2 = new Coordenada("Trabajo", -33.1234, -53.432);
		Coordenada coord3 = new Coordenada("Universidad", -31.2454, -52.665);
		
		CoordenadasJSON listaCoordenadasJSON = new CoordenadasJSON();
		listaCoordenadasJSON.addCoord(coord1);
		listaCoordenadasJSON.addCoord(coord2);
		listaCoordenadasJSON.addCoord(coord3);

		listaCoordenadasJSON.generarJSON("Coordenadas.JSON");
		
	}
	
}
