package zadaca2;

import java.util.Date;
import java.util.ArrayList;


public class Zapisnik {
	static ArrayList<String> lista = new ArrayList<String>();
	
	public void zapisnik (int brojRacuna, int brojKnjige, String Datum) {
		String izjava = "Korisnik " + brojRacuna + " je iznajmio " + " knjigu pod brojem " + brojKnjige + " i datum izdavanja je: " + Datum;
		lista.add(izjava);
	}
	public static void listaIzdatihKnjiga() {
		for (String object : lista)
			System.out.println(object);
	}
	
	public static boolean povratKnjige (int brojRacuna, int brojKnjige) {
		Date datum = new Date();
		String provjera = "Korisnik " + brojRacuna + " je iznajmio " + " knjigu pod brojem " + brojKnjige + " i datum izdavanja je: ";
		for (int i = 0; i < lista.size(); i++) {
			if (provjera.equals(lista.get(i).substring(0, 70))) {
				lista.set(i, " " + lista.get(i) + " (Datum vracanja je: " + datum.toString() + ")");
				return true;
			}
		}
		return false;
		}
	}
