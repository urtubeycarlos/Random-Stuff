import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMain {

	public static void main (String[] args){
		 //"foo" es la Regex // \\. es el punto . es el metacaracter [^prg] letras que no voy a considerar [a-z] un caracter de ese rango
		Pattern pattern = Pattern.compile("\\w+[\\w\\.]+@\\w+(\\.\\w+)+"); 
		Matcher matcher = pattern.matcher("Ahora con foo y foooo y refooooooomados"
				+ " patri.bagnes@gmail.sarasa.com.ar manden");
		
		while (matcher.find()){ //Si encontro a foo dentro del String ingresado.
			System.out.println("Encontre \"" + matcher.group() + "\" - ");
			System.out.println("Inicio: " + matcher.start() + ", fin: " +matcher.end());
		}
		
	}
}
