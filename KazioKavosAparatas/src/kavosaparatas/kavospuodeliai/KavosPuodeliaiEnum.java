package kavosaparatas.kavospuodeliai;

import kavosaparatas.puodeliuobjektai.KavosPuodelis;

public enum KavosPuodeliaiEnum {

    cappucino( new CapuccinoKavosPuodelis()),
    juoda( new JuodosKavosPuodelis()),
    machiatto(new MachiattoKavosPuodelis());

    private KavosPuodelis kavosTipas;

    KavosPuodeliaiEnum(KavosPuodelis kavosPuodelis) {
        this.kavosTipas = kavosPuodelis;
    }

    public KavosPuodelis getKavosTipas() {
        return kavosTipas;
    }
}
