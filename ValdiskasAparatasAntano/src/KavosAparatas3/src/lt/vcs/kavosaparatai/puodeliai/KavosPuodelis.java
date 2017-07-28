package KavosAparatas3.src.lt.vcs.kavosaparatai.puodeliai;

import KavosAparatas3.src.lt.vcs.kavosaparatai.resursai.Produktai;

public class KavosPuodelis extends Puodelis {
    protected Produktai produktai;

    protected String kavosPavadinimas;

    protected boolean kavaPagaminta = false;

    public KavosPuodelis(String kavosPavadinimas, int cukrus, int pupeles, int vanduo) {
        this.kavosPavadinimas = kavosPavadinimas;
        produktai = new Produktai(vanduo, cukrus, pupeles);
    }

    public boolean isKavaPagaminta() {
        return kavaPagaminta;
    }

    public void setKavaPagaminta(boolean kavaPagaminta) {
        this.kavaPagaminta = kavaPagaminta;
    }
    
    public Produktai getProduktai(){
        return this.produktai.gaukKopija();
    }

    @Override
    public String toString() {
        return kavosPavadinimas + (kavaPagaminta ? " pagamintas" : " nepagamintas");
    }

}
