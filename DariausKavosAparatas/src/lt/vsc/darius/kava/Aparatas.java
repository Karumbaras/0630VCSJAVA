package lt.vsc.darius.kava;

import lt.vsc.darius.produktai.*;
import lt.vsc.darius.puodai.PuodelisEspresso;
import lt.vsc.darius.puodai.PuodelisJuoda;
import lt.vsc.darius.puodai.PuodelisKavos;
import lt.vsc.darius.puodai.PuodelisSuPienu;

public class Aparatas {
	private static final int DEFAULT_PRODUKTO_REIKSME = 50;
	private static final int KADAVALYTI = 20;
	private static int kiekKavosPagamino = 0;

	private Produktai resursai;

	public static int getKadavalyti() {
		return KADAVALYTI;
	}

	// Konstruktorius
	public Aparatas(int vandens, int kavos, int pieno, int cukraus) {

		resursai = new Produktai(vandens, kavos, pieno, cukraus);
	}

	public Aparatas() {

		resursai = new Produktai(DEFAULT_PRODUKTO_REIKSME, DEFAULT_PRODUKTO_REIKSME, DEFAULT_PRODUKTO_REIKSME,
				DEFAULT_PRODUKTO_REIKSME);
	}

	// Metodai
	public void setProduktaiTokie(int vanduo, int pienas, int pupeles, int cukrus) {
		this.resursai.setCukrausKiekis(cukrus);
		this.resursai.setVandensKiekis(vanduo);
		this.resursai.setPupeliuKiekis(pupeles);
		this.resursai.setPienoKiekis(pienas);
	}

	public Produktai getProduktai() {
		return resursai;
	}

	public void setProduktai(Produktai produktai) {
		this.resursai = produktai;
	}

	public void setVandensKiekis(int kiekis) {
		this.resursai.setVandensKiekis(kiekis);
	}

	public void setPupeliuKiekis(int kiekis) {
		this.resursai.setPupeliuKiekis(kiekis);
	}

	public void setCukrausKiekis(int kiekis) {
		this.resursai.setCukrausKiekis(kiekis);
	}

	public void setPienoKiekis(int kiekis) {
		this.resursai.setPienoKiekis(kiekis);
	}

	public void papildykCukraus(int cukrus) {
		resursai.setCukrausKiekis(resursai.getCukrausKiekis() + cukrus);
	}

	public void papildykPupeliu(int pupeles) {
		resursai.setPupeliuKiekis(resursai.getPupeliuKiekis() + pupeles);
	}

	public void papildykVandens(int vanduo) {
		resursai.setVandensKiekis(resursai.getCukrausKiekis() + vanduo);
	}

	public void papildykPieno(int pienas) {
		resursai.setPienoKiekis(resursai.getPienoKiekis() + pienas);
	}

	public int kiekCukrausTuriu() {
		return resursai.getCukrausKiekis();
	}

	public int kiekVandensTuriu() {
		return resursai.getVandensKiekis();
	}

	public int kiekPupeliuTuriu() {
		return resursai.getPupeliuKiekis();
	}

	public int kiekPienoTuriu() {
		return resursai.getPienoKiekis();
	}

	private void mazinkKiekius(PuodelisKavos puodelis) {
		if ((resursai.getVandensKiekis() - puodelis.getProduktai().getVandensKiekis() > 0)
				&& (resursai.getPupeliuKiekis() - puodelis.getProduktai().getPupeliuKiekis() > 0)
				&& (resursai.getCukrausKiekis() - puodelis.getProduktai().getCukrausKiekis() > 0)
				&& (resursai.getPienoKiekis() - puodelis.getProduktai().getPienoKiekis() > 0)) {
			resursai.setVandensKiekis(resursai.getVandensKiekis() - puodelis.getProduktai().getVandensKiekis());
			resursai.setPupeliuKiekis(resursai.getPupeliuKiekis() - puodelis.getProduktai().getPupeliuKiekis());
			resursai.setCukrausKiekis(resursai.getCukrausKiekis() - puodelis.getProduktai().getCukrausKiekis());
			resursai.setPienoKiekis(resursai.getPienoKiekis() - puodelis.getProduktai().getPienoKiekis());
			puodelis.setKavaPagaminta(true);
		} else
			System.out.println("Truksta resursu");
	}

	private void gaminkJuoda() {
		PuodelisJuoda puodelis = new PuodelisJuoda();
		mazinkKiekius(puodelis);
		System.out.println(puodelis);
	}

	private void gaminkSuPienu() {
		PuodelisKavos puodelis = new PuodelisSuPienu();
		mazinkKiekius(puodelis);
		System.out.println(puodelis);
	}

	private void gaminkEspresso() {
		PuodelisKavos puodelis = new PuodelisEspresso();
		mazinkKiekius(puodelis);
		System.out.println(puodelis);

	}

	public void gaminkKava(int kokiaKava) {

		if (!this.arReikiaValyti()) {
			kiekKavosPagamino++;
			switch (kokiaKava) {
			case 1:
				gaminkJuoda();
				break;

			case 2:
				gaminkSuPienu();
				break;

			case 3:
				gaminkEspresso();
				break;
			}
		} else
			System.out.println("Klaida! Reikia valyti");

	}

	public boolean arReikiaValyti() {
		if (kiekKavosPagamino == KADAVALYTI)
			return true;
		else
			return false;
	}

	public void isvalyti() {
		kiekKavosPagamino = 0;
		System.out.println("Aparatas isvalytas");
	}

	public void kiekProduktuTuriu() {
		System.out.println("Vandens kiekis: " + resursai.getVandensKiekis());
		System.out.println("Pupeliu kiekis: " + resursai.getPupeliuKiekis());
		System.out.println("Cukraus kiekis: " + resursai.getCukrausKiekis());
		System.out.println("Pieno kiekis: " + resursai.getPienoKiekis());
	}

	public void aparatoBusena() {
		kiekProduktuTuriu();
		System.out.println("Liko iki valymo: " + (KADAVALYTI - Aparatas.kiekKavosPagamino));
	}
}
