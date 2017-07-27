package lt.vsc.darius.puodai;

import lt.vsc.darius.produktai.Produktai;

public class PuodelisKavos {
	
	protected Produktai produktai;

	protected String kavosPavadinimas;

	protected boolean arKavaPagaminta = false;

	public PuodelisKavos(String kavosPavadinimas, int vanduo , int pupeles, int cukrus, int pienas) {

		this.kavosPavadinimas = kavosPavadinimas;

		produktai = new Produktai(vanduo, pupeles, cukrus, pienas);
	}
	
	public Produktai getProduktai () {
		return this.produktai;
	}

	public boolean KavaPagaminta() {
		return arKavaPagaminta;
	}

	public void setKavaPagaminta(boolean arKavaPagaminta) {
		this.arKavaPagaminta = arKavaPagaminta;
	}

	@Override
	public String toString() {
		return kavosPavadinimas + (arKavaPagaminta ? " pagamintas" : " nepagamintas");
	}

}
