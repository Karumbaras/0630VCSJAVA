package lt.vsc.darius.produktai;

public class Produktai {

	private int vandensKiekis;
	private int pupeliuKiekis;
	private int cukrausKiekis;
	private int pienoKiekis;

	public int getVandensKiekis() {
		return this.vandensKiekis;
	}

	public void setVandensKiekis(int vandensKiekis) {
		this.vandensKiekis = vandensKiekis;
	}

	public int getPupeliuKiekis() {
		return this.pupeliuKiekis;
	}

	public void setPupeliuKiekis(int pupeliuKiekis) {
		this.pupeliuKiekis = pupeliuKiekis;
	}

	public int getCukrausKiekis() {
		return this.cukrausKiekis;
	}

	public void setCukrausKiekis(int cukrausKiekis) {
		this.cukrausKiekis = cukrausKiekis;
	}

	public int getPienoKiekis() {
		return this.pienoKiekis;
	}

	public void setPienoKiekis(int pienoKiekis) {
		this.pienoKiekis = pienoKiekis;
	}
	
	public void setProduktai(int vandensKiekis, int pupeliuKiekis, int cukrausKiekis, int pienoKiekis) {
		setVandensKiekis(vandensKiekis);
		setPupeliuKiekis(pupeliuKiekis);
		setCukrausKiekis(cukrausKiekis);
		setPienoKiekis(pienoKiekis);
		}
	
	public Produktai(int vandensKiekis, int pupeliuKiekis, int cukrausKiekis, int pienoKiekis) {
		this.vandensKiekis = vandensKiekis;
		this.pupeliuKiekis = pupeliuKiekis;
		this.cukrausKiekis = cukrausKiekis;
		this.pienoKiekis = pienoKiekis;
	}

	public void atspausdintProduktus () {
		System.out.println("Pieno " + this.pienoKiekis );
		System.out.println("Vandens " + this.vandensKiekis );
		System.out.println("Pupeliu " + this.pupeliuKiekis );
		System.out.println("Cukraus " + this.cukrausKiekis );
	}
}
