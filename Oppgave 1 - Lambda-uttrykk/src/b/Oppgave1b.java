package b;

import java.util.*;

public class Oppgave1b {

	public static int summerFunksjon() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Gi en verdi til funksjonen SummerFunksjon");
		
		int svar =sc.nextInt();
		sc.close();
		
		return svar;
	}
	
	public static int beregn (int a, int b, int summerFunksjon) {
		
		int sum = a+b;
		int størst =0;
		int Avstand = a-b;
		
		
		if (summerFunksjon>5) {
			 System.out.println("Summen av " + a 
					+ " og " + b + " = " 
					+ sum);
		}
		else if (summerFunksjon>0 || summerFunksjon<=5) {
			if (a>b) {
				a = størst;
			}
			else if (a<b) {
				b = størst;
			}
			else {
				System.out.println("a og b er like store");
			}
		}
		else if (summerFunksjon<0) {
			System.out.println("Avstanden (absoluttverdien av differansen) "
					+ "mellom " + a +
					" og " + b + " = " + 
					Avstand);
		}
		
		return 0;
		
	}
	public static void main(String[] args) {
		
	}

}
