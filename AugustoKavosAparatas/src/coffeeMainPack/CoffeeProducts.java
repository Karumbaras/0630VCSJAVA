package coffeeMainPack;

public class CoffeeProducts {
    // PRODUKTAI

    private int cukrus;
    private int pupeles;
    private int vanduo;

    // KONSTRUKTORIUS
    public CoffeeProducts(int cukrus, int pupeles, int vanduo) {
        this.cukrus = cukrus;
        this.pupeles = pupeles;
        this.vanduo = vanduo;
    }

    // KURIAMA KOPIJA
    public CoffeeProducts getCopy() {
        return new CoffeeProducts(this.cukrus, this.pupeles, this.vanduo);
    }

    //man sakė, kad rekomenduotina visus get'us ir set'us į kodo galą sukelt (tikiuosi nemelavo)
    public void setCukrus(int cukrus) {
        this.cukrus = cukrus;
    }

    public void setPupeles(int pupeles) {
        this.pupeles = pupeles;
    }

    public void setVanduo(int vanduo) {
        this.vanduo = vanduo;
    }

    public int getCukrus() {
        return cukrus;
    }

    public int getPupeles() {
        return pupeles;
    }

    public int getVanduo() {
        return vanduo;
    }

}
