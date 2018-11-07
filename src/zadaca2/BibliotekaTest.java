package zadaca2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotekaTest {

	public static void main(String[] args) throws Exception {
		

		System.out.println("***********************");
		System.out.println("Dobrodosli u biblioteku");
		System.out.println("***********************");
		

		Scanner input = new Scanner(System.in);

		ArrayList<KreiranjeRacuna> racuni = new ArrayList<KreiranjeRacuna>();
		ArrayList<KreiranjeKnjige> knjige = new ArrayList<KreiranjeKnjige>();
		
		Fajlovi.ucitajFajlove(racuni, knjige, Zapisnik.lista);
		
			

		
		int opcija = -1;
		izbornik();
		
		while(opcija != 0) {
			 opcija = reTry(input);


		switch (opcija) {

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
		case 5:
			Zapisnik.listaIzdatihKnjiga();
			break;
		case 0:
			Fajlovi.snimiUFajlove(racuni, knjige, Zapisnik.lista);
			System.out.println("Izabrali ste izlaz iz biblioteke");
			break;


		default:
				System.out.print("\nUnijeli ste pogresan broj! Pokusajte ponovo.\n");
				

			opcija = reTry(input);
			}
		if(opcija != 0) {
			izbornik();
			}
		}
	}
			
	
	static void izbornik() {
		System.out.println("\n***********************");
		System.out.println(" Izaberite opciju:" + "\n1. Kreiraj racun" + "\n2. Kreiraj knjigu"
				+ "\n3. Podigni knjigu" + "\n4. Vrati knjigu" + "\n5. Lista izdatih knjiga" + "\n0. Izlaz");	
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
