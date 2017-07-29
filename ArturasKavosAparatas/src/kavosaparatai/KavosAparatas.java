package kavosaparatai;
import produktai.Produktai;
import puodeliai.Balta;
import puodeliai.Espresso;
import puodeliai.Juoda;
import puodeliai.KavosPavadinimas;
import puodeliai.KavosPuodelis;
import java.util.*;

public class KavosAparatas {

	private int panaudojimuSkaicius = 0;
	public Produktai produktai0;

	private static final int PANAUDOJIMU_RIBA = 20;
	private static final int DEFAULT_PRODUCT = 20;

	public KavosAparatas(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		produktai0 = new Produktai(cukrausKiekis, pupeliuKiekis, vandensKiekis);
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

	
	public KavosPuodelis gaminkKava(String kavosPavadinimas) {
		KavosPavadinimas k= KavosPavadinimas.valueOf(kavosPavadinimas);
		
		KavosPuodelis puodelis = k.getKavosPuodeliai();
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
	/*public void gaminkKavaMap() {
		Map<String,KavosPuodelis> puodeliai=new HashMap<String, KavosPuodelis>();
		Scanner scanner=new Scanner(System.in);
		System.out.printf("Meniu:%nJuoda kava: JUODA%nBalta kava: BALTA%nEspresso kava: ESPRESSO");
		
		String pasirinktaKava=scanner.nextLine().toLowerCase();
		puodeliai.put("juoda", new Juoda());
		puodeliai.put("balda", new Balta());
		puodeliai.put("espresso", new Espresso());
		puodeliai.get(pasirinktaKava);
		gaminkKava(pasirinktaKava);
	}
*/
	
	private void gaminkKava(KavosPuodelis puodelis) {
		Produktai produktai = puodelis.getProduktai();
		gaminkKava(produktai.getCukrausKiekis(), produktai.getPupeliuKiekis(), produktai.getVandensKiekis());
		puodelis.setKavaPagaminta(true);
	}

	final private void gaminkKava(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		if (arUzteksProduktu(cukrausKiekis, pupeliuKiekis, vandensKiekis) && !arReikiaPlovimo()) {
			produktai0.setCukrausKiekis(produktai0.getCukrausKiekis() - cukrausKiekis);
			produktai0.setPupeliuKiekis(produktai0.getPupeliuKiekis() - pupeliuKiekis);
			produktai0.setVandensKiekis(produktai0.getVandensKiekis() - vandensKiekis);
			this.panaudojimuSkaicius++;
			System.out.println("Kava pagaminta!");
			
		}

	}

	boolean arUzteksProduktu(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		boolean atsakymas = true;
		if (produktai0.getCukrausKiekis() - cukrausKiekis < 0) {
			System.out.println("Neuztenka cukraus");
			atsakymas = false;
		}
		if (produktai0.getPupeliuKiekis() - pupeliuKiekis < 0) {
			System.out.println("Neuztenka pupeliu");
			atsakymas = false;
		}
		if (produktai0.getVandensKiekis() - vandensKiekis < 0) {
			System.out.println("Neuztenka vandens");
			atsakymas = false;
		}
		return atsakymas;

	}

	public void aparatoPapildymas(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		produktai0.setCukrausKiekis(produktai0.getCukrausKiekis() + cukrausKiekis);
		produktai0.setPupeliuKiekis(produktai0.getPupeliuKiekis() + pupeliuKiekis);
		produktai0.setVandensKiekis(produktai0.getVandensKiekis() + vandensKiekis);
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
		System.out.println("Cukraus kiekis: " + produktai0.getCukrausKiekis());
		System.out.println("Vandens kiekis: " + produktai0.getVandensKiekis());
		System.out.println("Pupeliu kiekis: " + produktai0.getPupeliuKiekis());
		System.out.println("Panaudojimu skaicius: " + getpanaudojimuSkaicius());
	}

	public int getpanaudojimuSkaicius() {
		return panaudojimuSkaicius;
	}

}
