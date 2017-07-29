package aptarnavimas;
import kavosaparatai.KavosAparatas;
import java.util.*;

public class Servisas {
	KavosAparatas[] kavosAparatuMasyvas;
	int aparatuSk = 0;
	private static int sukurtaAparatu;
	private ArrayList<KavosAparatas>aparatuList=new ArrayList<>();

	public Servisas(int aparatuSk) {
		kavosAparatuMasyvas = new KavosAparatas[aparatuSk];
		sukurkAparatus();
	}

	public void sukurkAparatus() {
		for (int i = 0; i < kavosAparatuMasyvas.length; i++) {
			kavosAparatuMasyvas[i] = new KavosAparatas(i);
			sukurtaAparatu++;
		}
	}
	/*public void sukurkAparatuList(int aparatuSk) {
		for (int i=0;i<aparatuSk; i++) {
			aparatuList.add(new KavosAparatas(i));
			sukurtaAparatu++;
		}
	}*/
	
	public static void getSukurtaAparatu() {
		System.out.println("Sukurta aparatu: "+sukurtaAparatu);
		
	}

	public void aparatuValymas(int aparatoNr) {
		System.out.println("Isvalyta cukraus: " + kavosAparatuMasyvas[aparatoNr - 1].produktai0.getCukrausKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai0.setCukrausKiekis(0);
		System.out.println("Isvalyta pupeliu: " + kavosAparatuMasyvas[aparatoNr - 1].produktai0.getPupeliuKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai0.setPupeliuKiekis(0);
		System.out.println("Isvalyta vandens: " + kavosAparatuMasyvas[aparatoNr - 1].produktai0.getVandensKiekis());
		kavosAparatuMasyvas[aparatoNr - 1].produktai0.setVandensKiekis(0);

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
			kavosAparatuMasyvas[i].produktai0.setCukrausKiekis(cukrausKiekis);
			kavosAparatuMasyvas[i].produktai0.setPupeliuKiekis(pupeliuKiekis);
			kavosAparatuMasyvas[i].produktai0.setVandensKiekis(vandensKiekis);

		}
	}
}
