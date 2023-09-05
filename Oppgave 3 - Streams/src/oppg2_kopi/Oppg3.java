package oppg2_kopi;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Oppg3 {

	public static void main(String[] args) {
		//Lag en Ansatt type liste som heter ansatte
				List<Ansatt> ansatte = new ArrayList<>();
				/*new Ansatt er 
				 * Fornavn,etternavn,kjønn,stilling,lønn
				 * */
				ansatte.add(new Ansatt("Aayla ", "Secura ", Kjonn.Dame, "Soldat", 350000));
				ansatte.add(new Ansatt("Anakin ", "Skywalker ", Kjonn.Mann, "General",10000000));
				ansatte.add(new Ansatt("Obi-Wan", " Kenobi", Kjonn.Mann, "General",10000000));
				ansatte.add(new Ansatt("Ahsoka "," Tano ", Kjonn.Dame, "Ex-General",10000000));
				ansatte.add(new Ansatt("Darth ", " Vader", Kjonn.Mann, "Leiemorder", 12345443));
	
System.out.println("\nOppgave a");
				
		/* Bruker 'ansatte.stream()' for å lage en stream av ansatt objektet
		 * Bruker 'map(Ansatt::getEtternavn)' for å bruke getEtternavn metoden på hver
		 * av objektene i ansatte listen.
		 * Deretter bruker man '.collect(Collectors.toList())' for å
		 * samle sammen alle etternavnene fra map metoden om til en ny
		 * liste.
		 * I tillegg siden alt denne operasjonen er samlet sammen i
		 * en variable som heter etterNavn i dette tilfellet, så 
		 * kan man bare skrive 'System.out.println(etterNavn)'
		 * etterpå for å skrive ut alle etternavnene
		 * */
				List<String> etterNavn = ansatte.stream()
						.map(Ansatt::getEtternavn)
						.collect(Collectors.toList());
				
				System.out.println(etterNavn);
				
				
	
System.out.println("\nOppgave b");
				
				/*	akkurat som over så må man først gjøre om ansatte objektet om til en stream
				 * med ansatte.stream.
				 * Men i motsettning til det som ble gjort ovenfor så skal man ikke få alle kjønn skrevet ut,
				 * så dermed så skal man IKKE bruke .map(Ansatt::getKjonn) her.
				 * Istedenfor så skal man bare finne ut ANTALL damer,
				 * så man bruker istendenfor .filter(ansatt -> ansatt.getKjonn()== Kjonn.Dame).
				 * Men dette filtrer bare antall damer til en gruppe, den forteller ikke antall damer i den gruppen,
				 * så man bruker deretter . count () for å returnere antall elementer i den gruppen og dermed antall damer
				 * i ansatte objektet.
				 * 
				 * I tillegg siden alt dette ble gjort i en variabel som heter kjonn i dette tilfellet, så kan man som ovenfor
				 * bare skrive System.out.println("Antall ansatte som er Damer er: " + kjonn); for å få det resultatet man leter etter 
				 * 
				 * P.S. siden dette er nå en boolean så må man bruke, (==), istenfor (=).
				 * I tillegg så valgte jeg å bruke \n for å gjøre det mer ryddig,
				 * det er ikke nødvendig å bruke den, men det ser bedre ut.
				 * I tillegg så ser det ut som om man ikke kan bruke int (variable) = {...}
				 * i streams. 
				 * Man må bruke long.
				 * */
				long kjonn=ansatte.stream()
						.filter(ansatt -> ansatt.getKjonn() == Kjonn.Dame)
						.count();
				
				System.out.println("\nAntall ansatte som er Damer er: " + kjonn);
				
	
	System.out.println("\nOppgave c");
				
				double gjennomsnittslonnD = ansatte.stream()
				        .filter(ansatt -> ansatt.getKjonn() == Kjonn.Dame)
				        .mapToInt(Ansatt::getAarslønn) 
				        .average()
				        .orElse(0.0);
				
				System.out.println("\nDen gjennomsnittelige lønnen til en Dame er "+gjennomsnittslonnD);
				        
				
System.out.println("\nOppgave d");
		// I dette tilfellet så er general en sjef
				List<Ansatt> lønnsøkningG = ansatte.stream()
		                .map(ansatt -> {
		                    if ("General".equals(ansatt.getStilling())) {
		                        int nylønn = (int) (ansatt.getAarslønn() * 1.07);
		                        ansatt.setaarslonn(nylønn);
		                    }
		                    return ansatt;
		                })
		                .collect(Collectors.toList());

		        Stream<Ansatt> kunGeneral = lønnsøkningG.stream()
		                .filter(ansatt -> ansatt.getStilling().equals("General"));

		        kunGeneral.forEach(ansatt-> {
		        		System.out.println("\n" +
		        				ansatt.getFornavn() + " " +
		        				        ansatt.getEtternavn() + " (" +
		        				        ansatt.getKjonn() + ") - " +
		        				        ansatt.getStilling() + ": " +
		        				        ansatt.getAarslønn()
		        				);
		        		
		        });
System.out.println("\nOppgave e");
		        long svar = ansatte.stream()
		        		.filter(ansatt->ansatt.getAarslønn()>800000)
		        		.count();
		        
		        if (svar>0) {
		        	System.out.println("\n"+svar +" personer tjener mer enn 800 000");
		        } else {
		        	System.out.println("\nIngen tjener mer enn 800 000");
		        }
		        
		        
				
System.out.println("\nOppgave f");

ansatte.forEach(ansatt-> {
	System.out.println("\n" +
			ansatt.getFornavn() + " " +
			        ansatt.getEtternavn() + " (" +
			        ansatt.getKjonn() + ") - " +
			        ansatt.getStilling() + ": " +
			        ansatt.getAarslønn());
	});

System.out.println("\nOppgave g");

System.out.println("\nÅrslønnene til hver person sortert fra minst til størst");
System.out.println("\n");
List<Map.Entry<String, Integer>> ansatteData = ansatte.stream()
		.map(ansatt -> new SimpleEntry<>(ansatt.getFornavn() + " " + ansatt.getEtternavn() + ": ", ansatt.getAarslønn()))
		.collect(Collectors.toList());

ansatteData.sort(Comparator.comparing(Map.Entry::getValue));

ansatteData.forEach(entry -> System.out.println(entry.getKey() + " Aarslønn: " + entry.getValue()));
	
System.out.println("\nOppgave h");
int sum = IntStream.range(1,1000)
		.filter(n->n%3==0||n%5==0)
		.sum();

System.out.println("\nSummen av heltall som er delelige med 3 eller 5 og som er mellom 1 og 1000 er: "+ sum);
	}
}
