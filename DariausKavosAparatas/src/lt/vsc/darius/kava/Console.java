package lt.vsc.darius.kava;

import java.util.Scanner;
import lt.vsc.darius.produktai.Aptarnavimas;
import lt.vsc.darius.produktai.Produktai;

public class Console {

	public Scanner ReadConsole = new Scanner(System.in);

	/*public static void clearScreen() {
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public Console mainMenu(Console console) {
		System.out.println("Kavos aparatas pradeda darba");

		int selection = 0;

		do {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[1] Sukurti kavos aparatus");
			System.out.println("[2] Atspausdinti meniu");
			System.out.println("[3] Baigti darba");
			System.out.print("\nIveskite pasirinkima: ");

			selection = ReadConsole.nextInt();
			switch (selection) {
			case 1: {

				System.out.println("Kiek aparatu sukurti?");
				System.out.print("Iveskite pasirinkima: ");
				int kiekAparatu = ReadConsole.nextInt();
				System.out.println("Ar aparatai naudos bendra resursa? 1 - taip, 2 - ne");
				System.out.print("Iveskite pasirinkima: ");
				int arBendriResursai = ReadConsole.nextInt();

				if (arBendriResursai == 1) {
					Aptarnavimas aparatai = new Aptarnavimas(kiekAparatu, true);
					System.out.println(" Sukurta " + kiekAparatu + " aparatai(tu) su bendrais resursais");
					console.submenu1(console, aparatai);
				} else if (arBendriResursai == 2) {
					Aptarnavimas aparatai = new Aptarnavimas(kiekAparatu, false);
					System.out.println(" Sukurta " + kiekAparatu + " aparatai(tu) su nepriklausomais resursais");
					console.submenu1(console, aparatai);
				} else {
					System.out.println("Netinkama ivestis, aparatai nesukurti");
					return console.mainMenu(console);
				}

			}
			case 2:
				return console.mainMenu(console);
			case 3:
				return console;
			default:
				System.out.println("Netinkamas pasirinkimas!");
			}
		} while (selection != 3);
		return console;
	}

	private Console submenu1(Console console, Aptarnavimas aparatai) {

		int selection = 0;

		do {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[1] Isplauti aparatus");
			System.out.println("[2] Visi aparatai gamina kava");
			System.out.println("[3] Isvalyti visu aparatu produktus");
			System.out.println("[4] Rodyti bendrus resursus");
			System.out.println("[5] Uzpildyk aparatus resursais");
			System.out.println("[6] Grizti");

			System.out.print("Iveskite pasirinkima: ");

			selection = ReadConsole.nextInt();

			switch (selection) {

			case 1:
				aparatai.isplaukVisusAparatus();
				return console.submenu1(console, aparatai);

			case 2:
				aparatai.visiAparataiGaminaRnd();
				return console.submenu1(console, aparatai);

			case 3:
				aparatai.isvalytiProduktus();
				return console.submenu1(console, aparatai);

			case 4:
				for (int i = 0; i < aparatai.aparatuMasyvas.length; i++) {

					System.out.println(i + 1 + "-ojo aparato resursas:");
					aparatai.aparatuMasyvas[i].kiekProduktuTuriu();
				}
				return console.submenu1(console, aparatai);

			case 5:
				Produktai p = new Produktai(50, 50, 50, 50);
				aparatai.priskirkBendraProdukta(aparatai.aparatuMasyvas, p);
				return console.submenu1(console, aparatai);

			default:
				System.out.println("Blogas pasirinkimas!");
			}
		} while (selection != 6);
		return console;
	}
}
