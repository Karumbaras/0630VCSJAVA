package lt.vcs.karolis.kavosAparatas.kavosPuodelis;

import lt.vcs.karolis.kavosAparatas.produktai.Produktai;

/**
 * Created by karolis somka on 7/19/2017.
 */

public class KavosPuodelis extends Puodelis {

    protected Produktai produktai;
    protected String kavosPavadinimas;
    private boolean arPagaminta = false;

    public KavosPuodelis(String kavosPavadinimas, Produktai produktai) {
        this.kavosPavadinimas = kavosPavadinimas;
        this.produktai = produktai;
    }

    public String toString() {
        if (arPagaminta) {
            return "Pagaminta " + kavosPavadinimas + " kava, ideta produktu: " + produktai;
        } else {
            return "Kava nebuvo pagaminta";
        }
    }

    public KavosPuodelis grazinkKopija() {
        return new KavosPuodelis(this.kavosPavadinimas, this.produktai);
    }

    public void setArPagaminta(boolean bukle) {
        this.arPagaminta = bukle;
    }

    public Produktai getProduktai() {
        return produktai;
    }
}
