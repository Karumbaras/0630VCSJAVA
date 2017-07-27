
public enum KavosPavadinimas {
	juoda(new Juoda()), balta(new Balta()), espresso(new Espresso());
	private KavosPuodeliai puodelis;
	KavosPavadinimas(KavosPuodeliai puodelis){
		this.puodelis=puodelis;
		
	}
	public KavosPuodeliai getKavosPuodeliai() {
		return puodelis;
	}

}
