package lt.vcs.karolis.kavosAparatas.kavosPuodelis;

public enum KavosPuodeliaiEnum {

    juoda( new JuodosKavosPuodelis()),
    americano( new AmericanoPuodelis()),
    espresso(new EspressoPuodelis());

    private KavosPuodelis kavosTipas;

    KavosPuodeliaiEnum(KavosPuodelis kavosPuodelis) {
        this.kavosTipas = kavosPuodelis;
    }

    public KavosPuodelis getKavosTipas() {
        return kavosTipas;
    }
}
