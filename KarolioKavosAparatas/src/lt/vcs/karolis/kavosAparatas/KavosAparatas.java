package lt.vcs.karolis.kavosAparatas;

import lt.vcs.karolis.kavosAparatas.exceptions.ReikiaPlautiAparata;
import lt.vcs.karolis.kavosAparatas.exceptions.TrukstaProduktu;
import lt.vcs.karolis.kavosAparatas.kavosPuodelis.*;
import lt.vcs.karolis.kavosAparatas.produktai.Produktai;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karolis somka on 7/13/2017.
 */
public class KavosAparatas {
    private int panaudojimai;
    private final int PANAUDOJIMAI_MAX = 5;
    public Produktai produktai;
    public static int sukurtuAparatuSkaicius = 0;
    private Map<String, KavosPuodelis> puodelisMap = new HashMap<>();

    public KavosAparatas(int cukrausKiekis, int kavosKiekis, int vandensKiekis, int pienoKiekis, int sokoladoKiekis, int panaudojimai) {
        produktai = new Produktai(cukrausKiekis, kavosKiekis, vandensKiekis, pienoKiekis, sokoladoKiekis);
        this.panaudojimai = panaudojimai;
        sukurtuAparatuSkaicius++;
        puodelisMap.put("juoda", new JuodosKavosPuodelis());
        puodelisMap.put("americano", new AmericanoPuodelis());
        puodelisMap.put("espresso", new EspressoPuodelis());
    }

    public KavosAparatas(int cukrausKiekis, int kavosKiekis, int vandensKiekis, int pienoKiekis, int sokoladoKiekis) {
        this(cukrausKiekis, kavosKiekis, vandensKiekis, pienoKiekis, sokoladoKiekis, 0);
    }

    public KavosAparatas(int cukrausKiekis, int kavosKiekis, int pienoKiekis, int sokoladoKiekis) {
        this(cukrausKiekis, kavosKiekis, 0, pienoKiekis, sokoladoKiekis, 0);
    }

    public KavosAparatas(int cukrausKiekis, int pienoKiekis, int sokoladoKiekis) {
        this(cukrausKiekis, 0, 0, pienoKiekis, sokoladoKiekis,0);
    }

    public void papildykKavos(int kavosKiekis) {
        this.produktai.setKavosKiekis(this.produktai.getKavosKiekis() + kavosKiekis);
        System.out.println("Prideta kavos!");
    }

    public void papildykCukraus(int cukrausKiekis) {
        this.produktai.setCukrausKiekis(this.produktai.getCukrausKiekis() + cukrausKiekis);
        System.out.println("Prideta cukraus!");
    }

    public void papildykVandens(int vandensKiekis) {
        this.produktai.setVandensKiekis(this.produktai.getVandensKiekis() + vandensKiekis);
        System.out.println("Papildyta vandens!");
    }

    public void isplaukAparata() {
        System.out.println("Aparatas isplautas.");
        this.setPanaudojimai(0);
    }

    public boolean arReikiaPlauti() {
        if (this.getPanaudojimai() == this.getPANAUDOJIMAI_MAX()) {
            try {
                throw new ReikiaPlautiAparata("Isplauk aparata!");
            } catch (ReikiaPlautiAparata reikiaPlautiAparata) {
                reikiaPlautiAparata.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public void paruoskKavos(String kavosRusis) {
        KavosPuodelis kavosPuodelis = KavosPuodeliaiEnum.valueOf(kavosRusis).getKavosTipas();
        //System.out.println(gaminkKava(kavosPuodelis));
        try {
            System.out.println(gaminkKava(kavosPuodelis));
        } catch (TrukstaProduktu trukstaProduktu) {
            trukstaProduktu.printStackTrace();
        }
    }

    private final KavosPuodelis gaminkKava(KavosPuodelis puodelis) throws TrukstaProduktu{
        if (arUzteksProduktu(puodelis.getProduktai()) && !arReikiaPlauti()) {
            this.produktai.setCukrausKiekis(this.produktai.getCukrausKiekis() - puodelis.getProduktai().getCukrausKiekis());
            this.produktai.setKavosKiekis(this.produktai.getKavosKiekis() - puodelis.getProduktai().getKavosKiekis());
            this.produktai.setVandensKiekis(this.produktai.getVandensKiekis() - puodelis.getProduktai().getVandensKiekis());
            puodelis.setArPagaminta(true);
            this.panaudojimai++;
        }
        return puodelis;
    }

    //metodai su Map
    /*
    public void paruoskKavosMap(String kavosRusis) {
        if (puodelisMap.containsKey(kavosRusis.toLowerCase())) {
            KavosPuodelis puodelioKopija = puodelisMap.get(kavosRusis.toLowerCase()).grazinkKopija();
            System.out.println(gaminkKava(puodelioKopija));
        } else {
            System.out.println("Tokios kavos aparatas negamina.");
        }
    }

    public void atspausdinkMap() {
        System.out.println(puodelisMap);
    }
    */

    private boolean arProduktaiNeNuliai() {
        return arUzteksProduktu(new Produktai(1, 1, 1, 1, 1));
    }

    private boolean arUzteksProduktu(Produktai produktai) {
        boolean uztenka = true;
        if (this.produktai.getCukrausKiekis() - produktai.getCukrausKiekis() < 0) {
            uztenka = false;
            System.out.println("Truksta cukraus.");
        } else if (this.produktai.getKavosKiekis() - produktai.getKavosKiekis() < 0) {
            uztenka = false;
            System.out.println("Truksta kavos.");
        } else if (this.produktai.getVandensKiekis() - produktai.getVandensKiekis() < 0) {
            uztenka = false;
            System.out.println("Truksta vandens.");
        }
        return uztenka;
    }

    private boolean arPasiruoses() {
        if (this.getPanaudojimai() == this.getPANAUDOJIMAI_MAX() && arProduktaiNeNuliai()) {
            System.out.println("Reikia isplauti aparata.");
            return false;
        } else {
            return true;
        }
    }

    public static void atspausdinkSukurtuAparatuSkaiciu() {
        System.out.println("Sukurta aparatu: " + sukurtuAparatuSkaicius);
    }

    @Override
    public String toString() {
        return "KavosAparatas{" +
                "cukrausKiekis= " + this.produktai.getCukrausKiekis() +
                ", kavosKiekis= " + this.produktai.getKavosKiekis() +
                ", vandensKiekis= " + this.produktai.getVandensKiekis() +
                ", panaudojimai= " + panaudojimai +
                '}';
    }

    public void setProduktai(Produktai produktai) {
        this.produktai = produktai;
    }

    public int getPanaudojimai() {
        return panaudojimai;
    }

    public void setPanaudojimai(int panaudojimai) {
        this.panaudojimai = panaudojimai;
    }

    public int getPANAUDOJIMAI_MAX() {
        return PANAUDOJIMAI_MAX;
    }
}
