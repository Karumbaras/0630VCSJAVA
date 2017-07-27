package kavosaparatas.produktai;

public class Produktai {

    private int cukrausKiekis;
    private int kavosPupeliuKiekis;
    private int vandensKiekis;

    public Produktai() {
    }

    public Produktai(int cukrausKiekis, int kavosPupeliuKiekis, int vandensKiekis) {
        this.cukrausKiekis = cukrausKiekis;
        this.kavosPupeliuKiekis = kavosPupeliuKiekis;
        this.vandensKiekis = vandensKiekis;
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

    public Produktai grazinkKopija() {
        return new Produktai(this.cukrausKiekis, this.kavosPupeliuKiekis, this.vandensKiekis);
    }
}
