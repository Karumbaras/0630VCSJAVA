package kavosaparatas.puodeliuobjektai;

import kavosaparatas.produktai.Produktai;

public class KavosPuodelis extends Puodelis {

    public Produktai produktai = new Produktai();
    protected String kavosVardas;
    protected boolean arKavaPagaminta;

    //-------------------
    //Perkeliau MAX_PUODELIO_TALPA is Puodelio klases, kad ja butu galima padaryti abstract.
    public static final int MAX_PUODELIO_TALPA = 6;

    public KavosPuodelis() {
    }

    public KavosPuodelis(String kavosVardas, int cukrusGaminimui, int kavosPupelesGaminimui, int vanduoGaminimui) {
        this.produktai.setCukrausKiekis(cukrusGaminimui);
        this.produktai.setKavosPupeliuKiekis(kavosPupelesGaminimui);
        this.produktai.setVandensKiekis(vanduoGaminimui);
        this.kavosVardas = kavosVardas;
    }

    public String getKavosVardas() {
        return kavosVardas;
    }

    public boolean isArKavaPagaminta() {
        return arKavaPagaminta;
    }

    public void setArKavaPagaminta() {
        this.arKavaPagaminta = true;
    }
}
