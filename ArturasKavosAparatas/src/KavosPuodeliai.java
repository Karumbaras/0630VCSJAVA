
public class KavosPuodeliai {
	Produktai produktai;
	boolean arKavaPagaminta;
	String kavosPavadinimas;
	
	public KavosPuodeliai(int cukrausKiekis, int pupeliuKiekis, int vandensKiekis,String pavadinimas) {
		produktai=new Produktai(cukrausKiekis, pupeliuKiekis, vandensKiekis);
		kavosPavadinimas=pavadinimas;
	}
	public Produktai getProduktai() {
		return this.produktai.gaukKopija();
	}
	

	
	

}
