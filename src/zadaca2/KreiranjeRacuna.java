package zadaca2;

import java.util.ArrayList;
import java.util.Scanner;

public class KreiranjeRacuna {

	private String name;
	private int brojRacuna;
	private int brojPodignutihKnjiga;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public int getBrojPodignutihKnjiga() {
		return brojPodignutihKnjiga;
	}

	public void setBrojPodignutihKnjiga(int brojPodignutihKnjiga) {
		this.brojPodignutihKnjiga = brojPodignutihKnjiga;
	}

	public static void kreirajRacun(ArrayList<KreiranjeRacuna> racuni, Scanner input) {
		

		KreiranjeRacuna racun = new KreiranjeRacuna();
		racuni.add(racun);
		System.out.println("Unesite vase ime:");
		String ime = input.nextLine();
		ime = input.nextLine();

		int broj = -1;
		while (broj < 0) {
			broj = (int) (Math.random() * 899 + 101);
			for (int i = 0; i < racuni.size(); i++) {
				if (racuni.get(i).getBrojRacuna() == broj) {
					broj = -1;
				}
			}
		}

		racuni.get(racuni.size() - 1).setName(ime);
		racuni.get(racuni.size() - 1).setBrojRacuna((int) (Math.random() * 899 + 101));
		racuni.get(racuni.size() - 1).setBrojPodignutihKnjiga(0);

		System.out.println("Zdravo " + racuni.get(racuni.size() - 1).getName() + "\nVas broj racuna je: "
				+ racuni.get(racuni.size() - 1).getBrojRacuna() + "\nBroj podignutih knjiga na vasem racunu je: "
				+ racuni.get(racuni.size() - 1).getBrojPodignutihKnjiga());
	}
}
