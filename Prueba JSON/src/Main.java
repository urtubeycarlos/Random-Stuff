
public class Main {

	public static void main(String[] args) {

//		Coordenada coord1 = new Coordenada("Casa", -34.2134, -54.325);
//		Coordenada coord2 = new Coordenada("Trabajo", -33.1234, -53.432);
//		Coordenada coord3 = new Coordenada("Universidad", -31.2454, -52.665);
//		
//		CoordenadasJSON listaCoordenadasJSON = new CoordenadasJSON();
//		listaCoordenadasJSON.addCoord(coord1);
//		listaCoordenadasJSON.addCoord(coord2);
//		listaCoordenadasJSON.addCoord(coord3);
//
//		listaCoordenadasJSON.generarJSON("src/Coordenadas.JSON");
		
		CoordenadasJSON coords = CoordenadasJSON.leerJSON("src/Coordenadas.JSON");
//		for(int i=0; i<coords.tamanio(); i++){
//			System.out.println(coords.dame(i));
//		}
		
		for(Coordenada c:coords.getIterable()){
			System.out.println(c);
		}
		
		
	}
	
}
