package kavosaparatas.aparatas;

import kavosaparatas.exceptions.ReikiaValytiAparata;
import kavosaparatas.exceptions.TrukstaProduktu;
import kavosaparatas.kavospuodeliai.CapuccinoKavosPuodelis;
import kavosaparatas.kavospuodeliai.JuodosKavosPuodelis;
import kavosaparatas.kavospuodeliai.KavosPuodeliaiEnum;
import kavosaparatas.kavospuodeliai.MachiattoKavosPuodelis;
import kavosaparatas.produktai.Produktai;
import kavosaparatas.puodeliuobjektai.KavosPuodelis;

import java.util.HashMap;
import java.util.Map;


public class KavosAparatas {

    private int panaudojimuSkaicius;
    private final int MAX_PANAUDOJIMU_SKAICIUS = 1;

    public Produktai produktai = new Produktai();
    Map<String, KavosPuodelis> kavosPuodukai = new HashMap<String, KavosPuodelis>();

    public KavosAparatas() {
    }

    public KavosAparatas(int cukrausKiekis, int kavosPupeliuKiekis, int vandensKiekis, int pienoKiekis) {

        this.produktai.setCukrausKiekis(cukrausKiekis);
        this.produktai.setKavosPupeliuKiekis(kavosPupeliuKiekis);
        this.produktai.setVandensKiekis(vandensKiekis);
        this.produktai.setPienoKiekis(pienoKiekis);
        kavosPuodukai.put("juoda", new JuodosKavosPuodelis());
        kavosPuodukai.put("cappucino", new CapuccinoKavosPuodelis());
        kavosPuodukai.put("machiatto", new MachiattoKavosPuodelis());
    }

    public void papildykVandens() {

        this.produktai.setVandensKiekis(15);
        System.out.println("Papildyta vandens.");
        naujaEilute();
    }

    public void papildykKavosPupeliu() {

        this.produktai.setKavosPupeliuKiekis(15);
        System.out.println("Papildytos kavos pupelės.");
        naujaEilute();
    }

    public void papildykCukraus() {

        this.produktai.setCukrausKiekis(15);
        System.out.println("Papildytas cukrus.");
        naujaEilute();
    }

    public void papildykPieno() {
        this.produktai.setPienoKiekis(15);
        System.out.println("Papildytas pienas.");
        naujaEilute();
    }

    //-------------------------
    //sukurti metoda tuscios eilutes spausdinimui

    public void priimkUzsakyma(String kava) {
        if(kavosPuodukai.containsKey(kava.toLowerCase())) {
            try {
                arVirsijaPanaudojimuSkaiciu();
            } catch (ReikiaValytiAparata e) {
                System.out.println(e.getMessage());
            }

            KavosPuodelis kavosPuodelis = KavosPuodeliaiEnum.valueOf(kava).getKavosTipas();

                try {
                    gaminkKava(kavosPuodelis);
                } catch (TrukstaProduktu e) {
                    System.out.println(e.getMessage());
                }
                naujaEilute();
        }
    }

    final public KavosPuodelis gaminkKava(KavosPuodelis kavosPuodelis) throws TrukstaProduktu{
            if (!arTrukstaProduktu(kavosPuodelis)) {

                this.produktai.setCukrausKiekis(this.produktai.getCukrausKiekis() - kavosPuodelis.produktai.getCukrausKiekis());
                this.produktai.setKavosPupeliuKiekis(this.produktai.getKavosPupeliuKiekis() - kavosPuodelis.produktai.getKavosPupeliuKiekis());
                this.produktai.setVandensKiekis(this.produktai.getVandensKiekis() - kavosPuodelis.produktai.getVandensKiekis());
                this.produktai.setPienoKiekis(this.produktai.getPienoKiekis() - kavosPuodelis.produktai.getPienoKiekis());
                this.panaudojimuSkaicius += 1;
                kavosPuodelis.setArKavaPagaminta();
                kavosPuodelis.setKiekPuodelisUzpildytas(kavosPuodelis.produktai.getCukrausKiekis() + kavosPuodelis.produktai.getKavosPupeliuKiekis() + kavosPuodelis.produktai.getVandensKiekis());

                if (kavosPuodelis.getKiekPuodelisUzpildytas() > kavosPuodelis.MAX_PUODELIO_TALPA) {
                    System.out.println("Pasidarei " + kavosPuodelis.getKavosVardas() + ", bet visur prilaistei kavos");
                } else {
                    System.out.println(kavosPuodelis.getKavosVardas() + " - " + "Ar kava pagaminta: "
                            + kavosPuodelis.isArKavaPagaminta() + ", puodelis užpildytas " + kavosPuodelis.getKiekPuodelisUzpildytas());
                }
            } else {
                throw new TrukstaProduktu();
            }

        return kavosPuodelis;
    }
    //---------------------------
    //Priimti produkto klases objekta kaip parametra? leistu sumazinti kodo kieki auksciau esanciame metode.
    //bet reiktu sukurti nauja metoda getProduktai KavosPuodelio klasei
    public boolean arTrukstaProduktu(KavosPuodelis kavosPuodelis) {
        boolean rezultatas = false;

        int cukrus = this.produktai.getCukrausKiekis() - kavosPuodelis.produktai.getCukrausKiekis();
        int kavosPupeles = this.produktai.getKavosPupeliuKiekis() - kavosPuodelis.produktai.getKavosPupeliuKiekis();
        int vanduo = this.produktai.getVandensKiekis() - kavosPuodelis.produktai.getVandensKiekis();
        int pienas = this.produktai.getPienoKiekis() - kavosPuodelis.produktai.getPienoKiekis();

        if (cukrus < 0 || kavosPupeles < 0 || vanduo < 0 || pienas < 0) {
            rezultatas = true;
        }

        return rezultatas;
    }

    public void arVirsijaPanaudojimuSkaiciu() throws ReikiaValytiAparata{

        if (this.panaudojimuSkaicius >= this.MAX_PANAUDOJIMU_SKAICIUS) {
            naujaEilute();
            throw new ReikiaValytiAparata();
        }
    }

    public void atlikPlovima() {
        if (this.panaudojimuSkaicius == 0) {
            System.out.println("Aparato nereikia plauti, nes jis švarus.");
            naujaEilute();
        } else {
            System.out.println("Aparatas išplautas.");
            naujaEilute();
            this.panaudojimuSkaicius = 0;
        }
    }

    public void arAparatasPasiruoses() {

        produktuBusena();

        if (this.produktai.getVandensKiekis() <= 0) {
            System.out.println("Aparate trūksta cukraus.");
        }

        if (this.produktai.getKavosPupeliuKiekis() <= 0) {
            System.out.println("Aparate trūksta kavos pupelių.");
        }

        if (this.produktai.getVandensKiekis() <= 0) {
            System.out.println("Aparate trūksta vandens.");
        }

        if (this.panaudojimuSkaicius <= 0) {
            System.out.println("Aparatas yra išvalytas.");
        }

        if (this.produktai.getPienoKiekis() <= 0) {
            System.out.println("Aparate trūksta pieno.");
        }

        if (this.panaudojimuSkaicius >= MAX_PANAUDOJIMU_SKAICIUS) {
            System.out.println("Aparatą reikia plauti.");
            naujaEilute();
        } else {
            System.out.println("Iki aparato plovimo liko " + (this.MAX_PANAUDOJIMU_SKAICIUS
                    - this.panaudojimuSkaicius) + " panaudojimo kartai/ų.");
        }
    }

    public void produktuBusena() {
        System.out.println("Aparate yra " + this.produktai.getCukrausKiekis() +
                " cukraus, " +              this.produktai.getKavosPupeliuKiekis() +
                " kavos pupelių, " +        this.produktai.getVandensKiekis() +
                " vandens, " + this.produktai.getPienoKiekis() + " pieno.");
    }

    public void atspausdinkPasirinkimuMeniu() {

        System.out.println("Pasirinkite, ką norite daryti: ");
        System.out.println("1. Pagaminti Juodą kavą ");
        System.out.println("2. Pagaminti Cappucino ");
        System.out.println("3. Pagaminti Machiatto ");
        System.out.println("4. Papildyti vandenį ");
        System.out.println("5. Papildyti kavos pupeles ");
        System.out.println("6. Papildyti cukrų ");
        System.out.println("7. Papildyti pieno ");
        System.out.println("8. Aparato būsena ");
        System.out.println("9. Plauti aparatą ");
        System.out.println("0. Baigti darbą ");
    }

    public Produktai setProduktai(int cukrus, int kavosPupeliuKiekis, int vandensKiekis, int pienoKiekis) {

        produktai.setCukrausKiekis(cukrus);
        produktai.setKavosPupeliuKiekis(kavosPupeliuKiekis);
        produktai.setVandensKiekis(vandensKiekis);
        produktai.setPienoKiekis(pienoKiekis);

        return produktai;
    }

    public void setProduktai(Produktai kavosAparatoProdauktai) {

        kavosAparatoProdauktai.setKavosPupeliuKiekis(produktai.getKavosPupeliuKiekis());
        kavosAparatoProdauktai.setVandensKiekis(produktai.getVandensKiekis());
        kavosAparatoProdauktai.setCukrausKiekis(produktai.getCukrausKiekis());
        kavosAparatoProdauktai.setPienoKiekis(produktai.getPienoKiekis());

    }

    public void isvalykAparata() {
        int isvalytosPupeles = this.produktai.getKavosPupeliuKiekis();
        int isvalytasVanduo = this.produktai.getVandensKiekis();
        int isvalytasCukrus = this.produktai.getCukrausKiekis();
        int isvalytasPienas = this.produktai.getPienoKiekis();
        this.produktai.setKavosPupeliuKiekis(0);
        this.produktai.setVandensKiekis(0);
        this.produktai.setCukrausKiekis(0);
        this.produktai.setPienoKiekis(0);
        System.out.println("Išvalė pupelių " + isvalytosPupeles +
        ", išvalė vandens " + isvalytasVanduo +
        ", išvalė cukraus " + isvalytasCukrus +
        ", išvalė pieno " + isvalytasPienas);
    }

    public void naujaEilute() {
        System.out.println("\n");
    }
}
