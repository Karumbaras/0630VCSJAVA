package kavosaparatas.puodeliuobjektai;

abstract class Puodelis {

    private int kiekPuodelisUzpildytas;

    public Puodelis() {
    }

    public int getKiekPuodelisUzpildytas() {
        return kiekPuodelisUzpildytas;
    }

    public void setKiekPuodelisUzpildytas(int kiekPuodelisUzpildytas) {
        this.kiekPuodelisUzpildytas = kiekPuodelisUzpildytas;
    }

    public void rodykInformacija() {
        System.out.println("Puodelio talpa - " + kiekPuodelisUzpildytas);
    }

}
