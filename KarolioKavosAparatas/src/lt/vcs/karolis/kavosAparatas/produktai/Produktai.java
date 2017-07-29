package lt.vcs.karolis.kavosAparatas.produktai;

/**
 * Created by somka on 7/14/2017.
 */
public class Produktai {
    private int cukrausKiekis;
    private int kavosKiekis;
    private int vandensKiekis;
    private int pienoKiekis;
    private int sokoladoKiekis;

    public Produktai(int cukrausKiekis, int kavosKiekis, int vandensKiekis, int pienoKiekis, int sokoladoKiekis) {
        this.cukrausKiekis = cukrausKiekis;
        this.kavosKiekis = kavosKiekis;
        this.vandensKiekis = vandensKiekis;
        this.pienoKiekis = pienoKiekis;
        this.sokoladoKiekis = sokoladoKiekis;
    }

    public int getPienoKiekis() {
        return pienoKiekis;
    }

    public void setPienoKiekis(int pienoKiekis) {
        this.pienoKiekis = pienoKiekis;
    }

    public int getSokoladoKiekis() {
        return sokoladoKiekis;
    }

    public void setSokoladoKiekis(int sokoladoKiekis) {
        this.sokoladoKiekis = sokoladoKiekis;
    }

    public int getCukrausKiekis() {
        return cukrausKiekis;
    }

    public void setCukrausKiekis(int cukrausKiekis) {
        this.cukrausKiekis = cukrausKiekis;
    }

    public int getKavosKiekis() {
        return kavosKiekis;
    }

    public void setKavosKiekis(int kavosKiekis) {
        this.kavosKiekis = kavosKiekis;
    }

    public int getVandensKiekis() {
        return vandensKiekis;
    }

    public void setVandensKiekis(int vandensKiekis) {
        this.vandensKiekis = vandensKiekis;
    }

    public Produktai grazinkKopija() {
        return new Produktai(this.cukrausKiekis, this.kavosKiekis, this.vandensKiekis, this.pienoKiekis, this.sokoladoKiekis );
    }

    public String toString() {
        return "Cukraus " + cukrausKiekis + ", kavos " + kavosKiekis + ", vandens " + vandensKiekis + ".";
    }
}
