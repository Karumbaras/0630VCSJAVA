package puodeliai;
public enum KavosPavadinimas {
	juoda(new Juoda()), balta(new Balta()), espresso(new Espresso());
	private KavosPuodelis puodelis;
	KavosPavadinimas(KavosPuodelis puodelis1){
		this.puodelis=puodelis1;
		
	}
	public KavosPuodelis getKavosPuodeliai() {
		return puodelis;
	}

}
