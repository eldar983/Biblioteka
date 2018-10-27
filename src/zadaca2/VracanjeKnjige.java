package zadaca2;

import java.util.ArrayList;

import java.util.Scanner;

public class VracanjeKnjige {
	
	public static void vratiKnjigu(ArrayList<KreiranjeKnjige> knjige, ArrayList<KreiranjeRacuna> racuni, Scanner input) {
		
		System.out.println("Unesite vas broj racuna: ");
		int brojRacunaKorisnika = input.nextInt();
		System.out.println("Unesite broj knjige koju zelite vratiti: ");
		int brojVraceneKnjige = input.nextInt();
		
		boolean provjera = Zapisnik.povratKnjige(brojRacunaKorisnika, brojVraceneKnjige);
		
		if (provjera) {
			for (KreiranjeRacuna object : racuni) {
				if(object.getBrojRacuna() == brojRacunaKorisnika)
					object.setBrojPodignutihKnjiga(object.getBrojPodignutihKnjiga() - 1);
				break;
			}
			for(KreiranjeKnjige object : knjige) {
				if(object.getBrojKnjige() == brojVraceneKnjige)
					object.setStatus(true);
				break;
			}
		}else {
			System.out.println("Vas broj racuna ili broj knjige nije ispravno unesen!");
		}	
	}
}
