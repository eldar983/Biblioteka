package zadaca2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


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
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		
		String datum = df.format(today);
		String provjera = "Korisnik " + brojRacuna + " je iznajmio " + " knjigu pod brojem " + brojKnjige + " i datum izdavanja je: ";
		for (int i = 0; i < lista.size(); i++) {
			if (provjera.equals(lista.get(i).substring(0, 70))) {
				lista.set(i, " " + lista.get(i) + " (Datum vracanja je: " + datum + ")");
				return true;
			}
		}
		return false;
		}
	}
