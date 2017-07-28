package KavosAparatas3.src.lt.vcs.kavosaparatai.resursai;

public class Produktai {
	private int vandensKiekis = 0;
	private int cukrausKiekis = 0;
	private int pupeliuKiekis = 0;

	public Produktai(int vandensKiekis, int cukrausKiekis, int pupeliuKiekis) {
		this.vandensKiekis = vandensKiekis;
		this.cukrausKiekis = cukrausKiekis;
		this.pupeliuKiekis = pupeliuKiekis;
	}

	
	public Produktai gaukKopija() {
		return new Produktai(vandensKiekis, cukrausKiekis, pupeliuKiekis);
	}

	public int getVandensKiekis() {
		return vandensKiekis;
	}

	public void setVandensKiekis(int vandensKiekis) {
		this.vandensKiekis = vandensKiekis;
	}

	public int getCukrausKiekis() {
		return cukrausKiekis;
	}

	public void setCukrausKiekis(int cukrausKiekis) {
		this.cukrausKiekis = cukrausKiekis;
	}

	public int getPupeliuKiekis() {
		return pupeliuKiekis;
	}

	public void setPupeliuKiekis(int pupeliuKiekis) {
		this.pupeliuKiekis = pupeliuKiekis;
	}
}
