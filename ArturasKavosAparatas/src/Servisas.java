
public class Servisas {
	KavosAparatas[] kavosAparatuMasyvas;
	int aparatuSk = 0;

	public Servisas(int aparatuSk) {
		kavosAparatuMasyvas = new KavosAparatas[aparatuSk];
	}

	public void aparatuMasyvas() {
		for (int i = 0; i < kavosAparatuMasyvas.length; i++) {
			kavosAparatuMasyvas[i] = new KavosAparatas(i);
		}
	}

	public void aparatuValymas(int aparatoNr) {
		System.out.println("Isvalyta cukraus: " + kavosAparatuMasyvas[aparatoNr - 1].produktai.getCukrausKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai.setCukrausKiekis(0);
		System.out.println("Isvalyta pupeliu: " + kavosAparatuMasyvas[aparatoNr - 1].produktai.getPupeliuKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai.setPupeliuKiekis(0);
		System.out.println("Isvalyta vandens: " + kavosAparatuMasyvas[aparatoNr - 1].produktai.getVandensKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai.setVandensKiekis(0);

	}

	public void aparatoPlovimas(int aparatoNr) {
		kavosAparatuMasyvas[aparatoNr - 1].plovimas();
	}

	public void visuAparatuPlovimas() {
		for (int i = 0; i < kavosAparatuMasyvas.length; i++) {
			kavosAparatuMasyvas[i] = new KavosAparatas(i);
			System.out.println("Aparatass: " + (i + 1));
			kavosAparatuMasyvas[i].plovimas();
			System.out.println();

		}
	}

	public void produktuPapildymas(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		for (int i = 0; i < kavosAparatuMasyvas.length; i++) {
			// kavosAparatuMasyvas[i] = new KavosAparatas(i);
			kavosAparatuMasyvas[i].produktai.setCukrausKiekis(cukrausKiekis);
			kavosAparatuMasyvas[i].produktai.setPupeliuKiekis(pupeliuKiekis);
			kavosAparatuMasyvas[i].produktai.setVandensKiekis(vandensKiekis);

		}
	}
}
