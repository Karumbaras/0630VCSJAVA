package puodeliai;
import produktai.Produktai;

public class KavosPuodelis extends Puodelis {
	protected Produktai produktai;
	protected boolean kavaPagaminta = false;
	protected String kavosPavadinimas;

	public KavosPuodelis(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis, String pavadinimas) {
		produktai = new Produktai(cukrausKiekis, pupeliuKiekis, vandensKiekis);
		kavosPavadinimas = pavadinimas;
	}

	public Produktai getProduktai() {
		
		return this.produktai.gaukKopija();
	}

	public boolean isKavaPagaminta() {
		System.out.println( kavaPagaminta);
		return kavaPagaminta;
	}

	public void setKavaPagaminta(boolean kavaPagaminta) {
		this.kavaPagaminta = kavaPagaminta;
	}

	@Override
	public String toString() {
		
		return  kavosPavadinimas + (kavaPagaminta ? "pagamintas" : "nepagamintas");
	}

}
