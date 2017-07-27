package coffeeMainPack;

public class KavosProduktai {
	// PRODUKTAI
	private int cukrus;

	public void setCukrus(int cukrus) {
		this.cukrus = cukrus;
	}

	public void setPupeles(int pupeles) {
		this.pupeles = pupeles;
	}

	public void setVanduo(int vanduo) {
		this.vanduo = vanduo;
	}

	private int pupeles;
	private int vanduo;

	// KONSTRUKTORIUS
	public KavosProduktai(int cukrus, int pupeles, int vanduo) {
		this.cukrus = cukrus;
		this.pupeles = pupeles;
		this.vanduo = vanduo;
	}

	// KURIAMA KOPIJA
	public KavosProduktai getCopy() {
		return new KavosProduktai(this.cukrus, this.pupeles, this.vanduo);
	}

	public int getCukrus() {
		return cukrus;
	}

	public int getPupeles() {
		return pupeles;
	}

	public int getVanduo() {
		return vanduo;
	}

}
