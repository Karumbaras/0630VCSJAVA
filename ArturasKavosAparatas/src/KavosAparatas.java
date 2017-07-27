
public class KavosAparatas {

	private int panaudojimuSkaicius = 0;
	public Produktai produktai;

	private static final int PANAUDOJIMU_RIBA = 20;
	private static final int DEFAULT_PRODUCT = 20;

	public KavosAparatas(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		produktai = new Produktai(cukrausKiekis, pupeliuKiekis, vandensKiekis);
	}

	public KavosAparatas(int cukrauKiekis, int pupeliuKiekis) {
		this(cukrauKiekis, pupeliuKiekis, DEFAULT_PRODUCT);
	}

	public KavosAparatas(int cukrauKiekis) {
		this(cukrauKiekis, DEFAULT_PRODUCT, DEFAULT_PRODUCT);
	}

	public KavosAparatas() {
		this(DEFAULT_PRODUCT, DEFAULT_PRODUCT, DEFAULT_PRODUCT);
	}

	// Kodel i metoda rasosi KavoPuodeliai, issiaiskint kavos puodelio gaminimo
	// metodus
	public KavosPuodeliai gaminkKava(String kavosPavadinimas) {
		KavosPavadinimas k= KavosPavadinimas.valueOf(kavosPavadinimas);
		
		KavosPuodeliai puodelis = k.getKavosPuodeliai();
		/*switch (kavosPavadinimas) {
		case "juoda":
			puodelis = new Juoda();
			break;
		case "balta":
			puodelis = new Balta();
			break;
		case "espresso":
			puodelis = new Espresso();
			break;
		default:
			System.out.println("Tokios kavos neturime: " + kavosPavadinimas);
			break;

		}*/
		if (puodelis != null)
			gaminkKava(puodelis);
		return puodelis;

	}

	// kam sitas metodas?
	private void gaminkKava(KavosPuodeliai puodelis) {
		Produktai produktai = puodelis.getProduktai();
		gaminkKava(produktai.getCukrausKiekis(), produktai.getPupeliuKiekis(), produktai.getVandensKiekis());
	}

	public void gaminkKava(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		if (arUzteksProduktu(cukrausKiekis, pupeliuKiekis, vandensKiekis) && !arReikiaPlovimo()) {
			produktai.setCukrausKiekis(produktai.getCukrausKiekis() - cukrausKiekis);
			produktai.setPupeliuKiekis(produktai.getPupeliuKiekis() - pupeliuKiekis);
			produktai.setVandensKiekis(produktai.getVandensKiekis() - vandensKiekis);
			this.panaudojimuSkaicius++;
			System.out.println("Kava pagaminta!");
		}

	}

	boolean arUzteksProduktu(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		boolean atsakymas = true;
		if (produktai.getCukrausKiekis() - cukrausKiekis < 0) {
			System.out.println("Neuztenka cukraus");
			atsakymas = false;
		}
		if (produktai.getPupeliuKiekis() - pupeliuKiekis < 0) {
			System.out.println("Neuztenka pupeliu");
			atsakymas = false;
		}
		if (produktai.getVandensKiekis() - vandensKiekis < 0) {
			System.out.println("Neuztenka vandens");
			atsakymas = false;
		}
		return atsakymas;

	}

	public void aparatoPapildymas(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		produktai.setCukrausKiekis(produktai.getCukrausKiekis() + cukrausKiekis);
		produktai.setPupeliuKiekis(produktai.getPupeliuKiekis() + pupeliuKiekis);
		produktai.setVandensKiekis(produktai.getVandensKiekis() + vandensKiekis);
	}

	public void plovimas() {
		if (panaudojimuSkaicius == 0) {
			System.out.println("Aparatas pasiruoses");
		}
		if (panaudojimuSkaicius >= PANAUDOJIMU_RIBA) {
			panaudojimuSkaicius = 0;
			System.out.println("Atliktas plovimas");
		}

	}

	public boolean arReikiaPlovimo() {
		if (panaudojimuSkaicius >= PANAUDOJIMU_RIBA) {
			System.out.println("Reikalingas plovimas");
			return true;
		} else
			return false;
	}

	public void aparatoBusena() {
		System.out.println("Cukraus kiekis: " + produktai.getCukrausKiekis());
		System.out.println("Vandens kiekis: " + produktai.getVandensKiekis());
		System.out.println("Pupeliu kiekis: " + produktai.getPupeliuKiekis());
		System.out.println("Panaudojimu skaicius: " + getpanaudojimuSkaicius());
	}

	public int getpanaudojimuSkaicius() {
		return panaudojimuSkaicius;
	}

}
