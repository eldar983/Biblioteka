package zadaca2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fajlovi {
	
	public static void snimiUFajlove(ArrayList<KreiranjeRacuna> racuni,
			ArrayList<KreiranjeKnjige> knjige, 
			ArrayList<String> zapisivanje) throws Exception{
		
		// upisemo stringove u file
		 FileWriter fwZapisivanje = new FileWriter("zapisnik.txt");
	    for (int i = 0; i < zapisivanje.size(); i++) {
	      fwZapisivanje.write(zapisivanje.get(i) + "\n");
	    }
	    fwZapisivanje.close();
	    
	    //Sad racuni
		String [] arrayRacuni = new String[racuni.size()];
		FileWriter fwRacuni = new FileWriter("racuni.txt");
		for(int i=0;i<racuni.size();i++) {
			arrayRacuni[i] = racuni.get(i).getBrojRacuna() + " "
					+ racuni.get(i).getBrojPodignutihKnjiga() + " "
					+ racuni.get(i).getName();
		}
		for (int i = 0; i < arrayRacuni.length; i++) {
		      fwRacuni.write(arrayRacuni[i] + "\n");
		    }
		fwRacuni.close();
		
		 //Sad knjige
		String [] arrayKnjige = new String[knjige.size()];
		FileWriter fwKnjige = new FileWriter("knjige.txt");
		for(int i=0;i<knjige.size();i++) {
			if(knjige.get(i).isStatus())
				arrayKnjige[i] = knjige.get(i).getBrojKnjige() + " "
					+ knjige.get(i).isStatus() + "* "//true* i false isto karaktera
					+ knjige.get(i).getNazivKnjige();
			else 
				arrayKnjige[i] = knjige.get(i).getBrojKnjige() + " "
						+ knjige.get(i).isStatus() + " "
						+ knjige.get(i).getNazivKnjige();
		}
		for (int i = 0; i < arrayKnjige.length; i++) {
		      fwKnjige.write(arrayKnjige[i] + "\n");
		    }
		fwKnjige.close();
		
	}	
	
		public static void ucitajFajlove(ArrayList<KreiranjeRacuna> racuni,
				ArrayList<KreiranjeKnjige> knjige,
				ArrayList<String> zapisivanje) throws Exception {
//sva tri fajla ucitamo
Scanner zapisnikUcitaj = new Scanner(new File("zapisnik.txt"));
Scanner racuniUcitaj = new Scanner(new File("racuni.txt"));
Scanner knjigeUcitaj = new Scanner(new File("knjige.txt"));
// jedan po jedan fajl stavljamo u nase arrayListe

//Prvo zapisnik, jer je svakako ArrayLista stringova
while(zapisnikUcitaj.hasNextLine()) {
	zapisivanje.add(zapisnikUcitaj.nextLine());
}
zapisnikUcitaj.close();

//Za racuni nam treba jedna dodatna arrayLista, i ovo je pocetno ucitavanje znaci 
// racuni i knjige su prazni
ArrayList<String> racuniString = new ArrayList<String>();
while(racuniUcitaj.hasNextLine()) {
	racuniString.add(racuniUcitaj.nextLine());
}
racuniUcitaj.close();


//napunili listu sa stringovima racuni sad cemo i sa knjige 

		ArrayList<String> knjigeString = new ArrayList<String>();
		while(knjigeUcitaj.hasNextLine()) {
			knjigeString.add(knjigeUcitaj.nextLine());
		}
		knjigeUcitaj.close();
		
		
		//ove dvije liste knjigeString i racuniString treba pretvoriti u objekte
		//i poredati u racuni listu i knjige listu jer one primaju objekte
		//za racuni string racuniString.get(i) izgleda npr: "983 1 Eldar"	
		
		for(int i=0;i<racuniString.size();i++) {
			KreiranjeRacuna racun = new KreiranjeRacuna();
			racuni.add(racun);
			//pokupio broj s pocetka stringa i dodijelim u polja objekta svakog
			racuni.get(i).setBrojRacuna(Integer.parseInt(racuniString.get(i).substring(0, 3)));
			racuni.get(i).setBrojPodignutihKnjiga(Integer.parseInt(racuniString.get(i).substring(4,5)));
			racuni.get(i).setName(racuniString.get(i).substring(6,racuniString.get(i).length()));
			}
		
		//i za knjige da napravimo listu objekata npr: "568 false Knjiga1"
				for(int i=0;i<knjigeString.size();i++) {
					KreiranjeKnjige knjiga = new KreiranjeKnjige();
					knjige.add(knjiga);
					//pokupio broj s pocetka stringa i dodijelim u polja objekta svakog
					knjige.get(i).setBrojKnjige(Integer.parseInt(knjigeString.get(i).substring(0, 3)));
					if(knjigeString.get(i).charAt(4)=='f')
						knjige.get(i).setStatus(false);
					else
						knjige.get(i).setStatus(true);
					// tamo gdje bude u file pisalo status ili ce biti false ili true* jer treba 5 karaktera tu 
					// a ne uticu na stanje u listama i programu samo da se lakse ime dodijeli
					knjige.get(i).setNazivKnjige(knjigeString.get(i).substring(10,knjigeString.get(i).length()));
			}

}
}
