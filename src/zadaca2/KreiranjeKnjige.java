package zadaca2;

import java.util.ArrayList;

import java.util.Scanner;

public class KreiranjeKnjige {

	private int brojKnjige;
	private String nazivKnjige;
	private boolean status;

	public int getBrojKnjige() {
		return brojKnjige;
	}

	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

	public void setNazivKnjige(String nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static void kreirajKnjigu(ArrayList<KreiranjeKnjige> knjige, Scanner input) {
		KreiranjeKnjige knjiga = new KreiranjeKnjige();
		knjige.add(knjiga);
		int broj = -1;
		while (broj < 0) {
			broj = (int) (Math.random() * 899 + 101);
			for (int i = 0; i < knjige.size(); i++) {
				if (knjige.get(i).getBrojKnjige() == broj) {
					broj = -1;
				}
			}
		}
		System.out.println("Unesite naziv knjige: ");
		String imeKnjige = input.nextLine();
		imeKnjige = input.nextLine();
		knjige.get(knjige.size() - 1).setNazivKnjige(imeKnjige);
		knjige.get(knjige.size() - 1).setBrojKnjige((int) (Math.random() * 899 + 101));
		knjige.get(knjige.size() - 1).setStatus(true);

		System.out.println("Naziv knjige koju ste kreirali je: " + knjige.get(knjige.size() - 1).getNazivKnjige()
				+ "\nBroj knjige koju ste kreirali je: " + knjige.get(knjige.size() - 1).getBrojKnjige()
				+ "\nStatus kreirane knjige(da li je dostupna): " + knjige.get(knjige.size() - 1).isStatus());
	}
}
