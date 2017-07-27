
 public class Produktai {
	private int cukrausKiekis = 0;
	private int pupeliuKiekis = 0;
	private int vandensKiekis = 0;
	

	public Produktai(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis) {
		this.cukrausKiekis = cukrausKiekis;
		this.pupeliuKiekis = pupeliuKiekis;
		this.vandensKiekis = vandensKiekis;
	}
	//Kam reikalinga kopija?
	public Produktai gaukKopija() {
		return new Produktai( cukrausKiekis,  pupeliuKiekis,  vandensKiekis);
	}

	

	public void setCukrausKiekis(int cukrausKiekis) {
		this.cukrausKiekis = cukrausKiekis;
	}

	public void setPupeliuKiekis(int pupeliuKiekis) {
		this.pupeliuKiekis = pupeliuKiekis;
	}

	public void setVandensKiekis(int vandensKiekis) {
		this.vandensKiekis = vandensKiekis;
	}

	public int getCukrausKiekis() {
		
		return cukrausKiekis;
	}

	public int getPupeliuKiekis() {
		return pupeliuKiekis;
	}

	public int getVandensKiekis() {
		return vandensKiekis;
	}
}
