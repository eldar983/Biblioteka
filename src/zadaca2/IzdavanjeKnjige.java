package zadaca2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class IzdavanjeKnjige {
	
	public static void izdajKnjigu(ArrayList<KreiranjeKnjige> knjige, ArrayList<KreiranjeRacuna> racuni, Scanner input) {
		Zapisnik zapisnikObject = new Zapisnik();
		int brojKnjige = 0;
		boolean provjera = true;
		
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		
		String datumIzdavanja = df.format(today);
		int brojRacunaKorisnika = 0;
		boolean ima3Knjige = false;
		while(provjera) {
			System.out.println("Dobrodsli u odjel za izdavanje knjige.\nUnesite svoj broj racuna: ");
			
			brojRacunaKorisnika = BibliotekaTest.reTry(input);
			
			for(int i = 0; i < racuni.size(); i++) {
				if(racuni.get(i).getBrojRacuna() == brojRacunaKorisnika) {
					provjera = false;
					int brojPodignutihKnjiga = racuni.get(i).getBrojPodignutihKnjiga();
					if (brojPodignutihKnjiga < 3)
						racuni.get(i).setBrojPodignutihKnjiga(brojPodignutihKnjiga + 1);
					else {
						System.out.println("Imate vec 3 podignute knjige na vasem racunu.\nNije dozvoljeno iznajmiti vise od 3 knjige.");
						ima3Knjige = true;
						break;
					}
				}
			}
			if(ima3Knjige) {
				break;
			}
			if(provjera) {
				System.out.println("Unijeli ste pogresan broj racuna");
			}
			if(!provjera) {
				System.out.println("Unesite broj knjige koju zelite podignuti: ");
				 brojKnjige = BibliotekaTest.reTry(input);
				 int provjeraKnjige = 0;
				 while(provjeraKnjige < knjige.size()) {
				
					if(knjige.get(provjeraKnjige).getBrojKnjige() == brojKnjige && knjige.get(provjeraKnjige).isStatus() == true) {
						System.out.println("Izvolite vasu knjigu, i ne zaboravite je vratiti kada zavrsite sa citanjem :)");
						knjige.get(provjeraKnjige).setStatus(false);
						zapisnikObject.zapisnik(brojRacunaKorisnika, knjige.get(provjeraKnjige).getBrojKnjige(), datumIzdavanja);
						provjeraKnjige++;
						break;
					}
					
					else if(provjeraKnjige == knjige.size() -1) {
						System.out.println("Uneseni broj knjige nije pronadjen, provjerite da li imate tacan broj i pokusajte ponovo: ");
						brojKnjige = BibliotekaTest.reTry(input);
						provjeraKnjige = 0;
					}
					else 
						provjeraKnjige++;
				}
			}
		}		
	}
}
