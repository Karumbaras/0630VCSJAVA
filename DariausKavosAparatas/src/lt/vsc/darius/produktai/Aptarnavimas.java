package lt.vsc.darius.produktai;

import java.util.Random;

import lt.vsc.darius.kava.*;


public class Aptarnavimas {

	public Aparatas aparatuMasyvas[];
	public static boolean arBendriResursai = false;

	public Aparatas[] getAparatuMasyvas() {
		return aparatuMasyvas;
	}

	public Aptarnavimas(int kiekAparatu, boolean arBendriResursai) {

		this.aparatuMasyvas = new Aparatas[kiekAparatu];
		for (int i = 0; i < kiekAparatu; i++) {
			aparatuMasyvas[i] = new Aparatas();
		}
		if (arBendriResursai) {
			Produktai produktaiBendri = new Produktai(50, 50, 50, 50);
			priskirkBendraProdukta(aparatuMasyvas, produktaiBendri);

		}

	}

	public void isplaukAparata(int i) {
		aparatuMasyvas[i].isvalyti();
	}

	public void isplaukVisusAparatus() {
		for (int i = 0; i < aparatuMasyvas.length; i++) {
			this.aparatuMasyvas[i].isvalyti();
		}
	}

	public void isvalytiProduktus() {
		Produktai kiekIsvaliau = new Produktai(0, 0, 0, 0);
		System.out.println("Isvaliau tiek produktu: ");
		for (int i = 0; i < this.aparatuMasyvas.length; i++) {
			kiekIsvaliau.setCukrausKiekis(kiekIsvaliau.getCukrausKiekis() + aparatuMasyvas[i].kiekCukrausTuriu());
			kiekIsvaliau.setVandensKiekis(kiekIsvaliau.getVandensKiekis() + aparatuMasyvas[i].kiekVandensTuriu());
			kiekIsvaliau.setPupeliuKiekis(kiekIsvaliau.getPupeliuKiekis() + aparatuMasyvas[i].kiekPupeliuTuriu());
			kiekIsvaliau.setPienoKiekis(kiekIsvaliau.getPienoKiekis() + aparatuMasyvas[i].kiekPienoTuriu());
			aparatuMasyvas[i].setProduktaiTokie(0, 0, 0, 0);
		}
		System.out.println("Isvaliau tiek produktu: ");
		kiekIsvaliau.atspausdintProduktus();
	}

	public void visiAparataiGaminaRnd() {
		Random ran = new Random();

		for (int i = 0; i < aparatuMasyvas.length; i++) {
			int kokiaKava = ran.nextInt(3);
			aparatuMasyvas[i].gaminkKava(kokiaKava);
		}
		
	}

	public void priskirkAtskiraProdukta(Aparatas[] kavosAparatai) {
		for (int i = 0; i < kavosAparatai.length; i++) {
			kavosAparatai[i].setProduktai(new Produktai(10, 10, 10, 10));
		}
	}

	public void priskirkBendraProdukta(Aparatas[] kavosAparatai, Produktai bendriProduktai) {
		for (int i = 0; i < kavosAparatai.length; i++) {
			kavosAparatai[i].setProduktai(bendriProduktai);
		}
	}

}
