package zadaca2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotekaTest {

	public static void main(String[] args) {
		

		System.out.println("***********************");
		System.out.println("Dobrodosli u biblioteku");
		System.out.println("***********************");
		

		Scanner input = new Scanner(System.in);

		ArrayList<KreiranjeRacuna> racuni = new ArrayList<KreiranjeRacuna>();
		ArrayList<KreiranjeKnjige> knjige = new ArrayList<KreiranjeKnjige>();
		
			izbornik();

		
		int opcija = -1;
		
		while(opcija != 0) {
			int izbor = reTry(input);


		switch (izbor) {

		case 1:
			KreiranjeRacuna.kreirajRacun(racuni, input);
			break;
		case 2:
			KreiranjeKnjige.kreirajKnjigu(knjige, input);
			break;
		case 3:
			IzdavanjeKnjige.izdajKnjigu(knjige, racuni, input);
			break;
		case 4:
			VracanjeKnjige.vratiKnjigu(knjige, racuni, input);
			break;
		case 0:
			System.out.println("Izabrali ste izlaz iz biblioteke");
			break;


		default:
				System.out.print("\nUnijeli ste pogresan broj! Pokusajte ponovo.\n");
				

			izbor = reTry(input);
			}
		izbornik();
		}
	}
			
	
	static void izbornik() {
		System.out.println("\n***********************");
		System.out.println(" Izaberite opciju:" + "\n1. Kreiraj racun" + "\n2. Kreiraj knjigu"
				+ "\n3. Podigni knjigu" + "\n4. Vrati knjigu" + "\n0. Izlaz");	
		System.out.println("***********************");
	}
	
	public static int reTry(Scanner input) {

		 try {
		     return input.nextInt();
		 } catch (InputMismatchException ex) {
			     input.nextLine(); //Ova ovdje linija koda ce prebaciti kursor na sljedecu liniju
			     System.out.println("Unos mora biti tipa Integer, pokusajte ponovo:");
			     return reTry(input);
			 }

		 }
}
