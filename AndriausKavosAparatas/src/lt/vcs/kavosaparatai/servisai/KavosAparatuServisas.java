package lt.vcs.kavosaparatai.servisai;

import lt.vcs.kavosaparatai.aparatai.KavosAparatas;
import lt.vcs.kavosaparatai.resursai.Produktai;

public class KavosAparatuServisas {

	public KavosAparatas[] sukurkKavosAparatus(int skaicius) {
		KavosAparatas[] kavosAparatai = new KavosAparatas[skaicius];

		for (int i = 0; i < kavosAparatai.length; i++) {
			kavosAparatai[i] = new KavosAparatas();
		}

		return kavosAparatai;
	}

	private void sumuokProduktus(Produktai produktuSuma, Produktai produktaiPrideti) {
		produktuSuma.setCukrausKiekis(produktuSuma.getCukrausKiekis() + produktaiPrideti.getCukrausKiekis());
		produktuSuma.setPupeliuKiekis(produktuSuma.getPupeliuKiekis() + produktaiPrideti.getPupeliuKiekis());
		produktuSuma.setVandensKiekis(produktuSuma.getVandensKiekis() + produktaiPrideti.getVandensKiekis());
	}

	public void isvalykAparatuProduktus(KavosAparatas[] kavosAparatai) {

		Produktai produktuSuma = new Produktai(0, 0, 0);

		for (int i = 0; i < kavosAparatai.length; i++) {
			sumuokProduktus(produktuSuma, kavosAparatai[i].getProduktai());
			kavosAparatai[i].isvalykProduktus();
		}

		System.out.println("Isvalyta cukraus: " + produktuSuma.getCukrausKiekis());
		System.out.println("Isvalyta pupeliu: " + produktuSuma.getPupeliuKiekis());
		System.out.println("Isvalyta vandens: " + produktuSuma.getVandensKiekis());
	}

	public void isplaukAparatus(KavosAparatas[] kavosAparatai) {
		for (int i = 0; i < kavosAparatai.length; i++) {
			// Kreipiuosi i sukurta vino aparato plovimo metoda; galima kreiptis
			// ir kavosAparatai[i].atlikPlovima();
			isplaukAparatà(kavosAparatai[i]);
		}
	}

	public void priskirkVisiemsTaPatiProdukta(KavosAparatas[] kavosAparatai, Produktai produktai) {
		for (int i = 0; i < kavosAparatai.length; i++) {
			kavosAparatai[i].setProduktai(produktai);
		}
	}

	public void priskirkVisiemsTaAtskiraProdukta(KavosAparatas[] kavosAparatai) {
		for (int i = 0; i < kavosAparatai.length; i++) {
			kavosAparatai[i].setProduktai(new Produktai(40, 40, 40
					));
		}
	}

	public void isplaukAparatà(KavosAparatas kavosAparatas) {
		kavosAparatas.atlikPlovima();
	}
}
