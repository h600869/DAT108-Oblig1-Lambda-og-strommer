package b;

import java.util.*;

public class Oppgave1b {

	public static int beregn (int a, int b, int summerFunksjon) {
		
		int resultat = 0;

        switch (summerFunksjon) {
            case 1: // Summen
                resultat = a + b;
                break;
            case 2: // Største av de to tallene
                resultat = Math.max(a, b);
                break;
            case 3: // Avstanden (absoluttverdien av differansen)
                resultat = Math.abs(a - b);
                break;
            default:
                System.out.println("Ugyldig valg.");
        }

        return resultat;
		
	}
	public static void main(String[] args) {
		int sum = beregn(12,13,1); //Summen av 12 og 13
		System.out.println("Summen av 12 og 13 er: " + sum);
		
		
		int maks = beregn(-5,3,2); //Den største av -5 og 3
		System.out.println("Det største av -5 og 3 er: " + maks);
		
		int avstand = beregn(54,45,3); /*Avstanden (absoluttverdien
										av differansen) 
										mellom 54 og 45*/
		System.out.println("Avstanden mellom 54 og 45 er: " + avstand);
	}

}
