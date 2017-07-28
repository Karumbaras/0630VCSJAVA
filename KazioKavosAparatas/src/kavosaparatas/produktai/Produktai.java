package kavosaparatas.produktai;

public class Produktai {

    //added private int pienoKiekis;
    private int cukrausKiekis;
    private int kavosPupeliuKiekis;
    private int vandensKiekis;
    private int pienoKiekis;

    public Produktai() {
    }

    public Produktai(int cukrausKiekis, int kavosPupeliuKiekis, int vandensKiekis, int pienoKiekis) {
        this.cukrausKiekis = cukrausKiekis;
        this.kavosPupeliuKiekis = kavosPupeliuKiekis;
        this.vandensKiekis = vandensKiekis;
        this.pienoKiekis = pienoKiekis;
    }

    public int getCukrausKiekis() {
        return cukrausKiekis;
    }

    public void setCukrausKiekis(int cukrausKiekis) {
        this.cukrausKiekis = cukrausKiekis;
    }

    public int getKavosPupeliuKiekis() {
        return kavosPupeliuKiekis;
    }

    public void setKavosPupeliuKiekis(int kavosPupeliuKiekis) {
        this.kavosPupeliuKiekis = kavosPupeliuKiekis;
    }

    public int getVandensKiekis() {
        return vandensKiekis;
    }

    public void setVandensKiekis(int vandensKiekis) {
        this.vandensKiekis = vandensKiekis;
    }

    public int getPienoKiekis() {
        return pienoKiekis;
    }

    public void setPienoKiekis(int pienoKiekis) {
        this.pienoKiekis = pienoKiekis;
    }

    public Produktai grazinkKopija() {
        return new Produktai(this.cukrausKiekis, this.kavosPupeliuKiekis, this.vandensKiekis, this.pienoKiekis);
    }
}
