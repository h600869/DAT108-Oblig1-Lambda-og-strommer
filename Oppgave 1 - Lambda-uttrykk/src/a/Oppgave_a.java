package a;

import java.util.*;

public class Oppgave_a {

	public static void main(String[] args) {
		//Lage en liste av navn
		List<String> listen = Arrays.asList("10","1","20","110","21","12");
		
		//Sortere listen ved bruk av Collections.sort metoden
		/* Virker ved å bruke Integer.parseInt metoden
		 * på både a og b.
		 * Deretter se om a er større eller mindre enn b
		 * Målet er at a er mindre enn b.
		 * Så den prøver å få en (-) resultat
		 * */
		Collections.sort((listen),(a,b)-> Integer.parseInt(a)-Integer.parseInt(b));
		
		
		System.out.println(listen);
		
	}

}
