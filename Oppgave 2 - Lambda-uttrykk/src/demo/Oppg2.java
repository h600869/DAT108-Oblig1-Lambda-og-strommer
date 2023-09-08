package demo;

import java.util.*;
import java.util.function.Function;

public class Oppg2 {

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> lonnsendring) {
        for (Ansatt ansatt : ansatte) {
            int nyLonnsendring = lonnsendring.apply(ansatt);
            ansatt.setaarslonn(nyLonnsendring);
        }
    }
	
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt ansatt: ansatte) {
			System.out.println("Fornavn: " + ansatt.getFornavn() 
			+ " Etternavn: " + ansatt.getEtternavn()
			+ "\nKjønn: " + ansatt.getKjonn()
			+"\nStilling: " + ansatt.getStilling()
			+ "\nÅrslønn: " + ansatt.getAarslønn()+" Imperial Credits"
			+ "\n");
		}
	}
	
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
		
		//i. Et fast kronetillegg
		lonnsoppgjor(ansatte, ansatt -> ansatt.getAarslønn()+1500);
		
		//ii. Et fast prosenttillegg (+15% i dette tilfelle)
		lonnsoppgjor(ansatte,ansatt->ansatt.getAarslønn()+(int)(ansatt.getAarslønn()*0.15));
	
		//iii. Et fast kronetillegg hvis du har lav lønn
		lonnsoppgjor(ansatte, ansatt -> {
            if (ansatt.getAarslønn() < 30000) {
                return ansatt.getAarslønn() + 2000; // Fast kronetillegg hvis lav lønn
            } else {
                return ansatt.getAarslønn();
            }
	});
		
		//iv. Et fast prosenttillegg hvis du er mann
		lonnsoppgjor(ansatte, ansatt -> {
            if (ansatt.getKjonn() == Kjonn.Mann) {
                return ansatt.getAarslønn() + (int)(ansatt.getAarslønn() * 0.03); // Fast prosenttillegg for menn
            } else {
                return ansatt.getAarslønn();
            }
        });
		
		// Skriver ut hele listen av ansatte
		skrivUtAlle(ansatte);

}
	}
