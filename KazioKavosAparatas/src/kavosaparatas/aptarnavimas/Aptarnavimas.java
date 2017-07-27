package kavosaparatas.aptarnavimas;

import kavosaparatas.aparatas.KavosAparatas;
import kavosaparatas.produktai.Produktai;

import java.util.*;

public class Aptarnavimas {

    int isvalytasVanduo = 0;
    int isvalytosKavosPupeles = 0;
    int isvalytasCukrus = 0;

    public KavosAparatas[] sukurkAparatus(KavosAparatas[] aparatai, int skaicius) {

        if (aparatai != null) {
            for (int i = 0; i < skaicius; i++) {
                aparatai[i] = new KavosAparatas(1, 2, 3);
            }
            return aparatai;
        }
        return null;
    }

    public List sukurkAparatus(List<KavosAparatas> aparatai, int skaicius) {

        if (aparatai != null) {
            for (int i = 0; i < skaicius; i++) {
                aparatai.add(new KavosAparatas(3,2,1));
            }
            return aparatai;
        }
        return null;
    }

    public Map sukurkAparatus(HashMap<Integer, KavosAparatas> aparatai, int skaicius) {

        if (aparatai != null) {
            for (int i = 0; i < skaicius; i++) {
                aparatai.put(i, new KavosAparatas(2, 2, 2));
            }
            return aparatai;
        }
        return null;
    }

    //---------------------------
    //Sitie trys metodai duplikuoja zemiau esancius isvalykAparatuProduktus metodus.
    public KavosAparatas[] isvalykPaduotusAparatus(KavosAparatas[] aparatai) {

        if (aparatai != null) {

            for (int i = 0; i < aparatai.length; i++) {
                isvalytasVanduo += aparatai[i].produktai.getVandensKiekis();
                isvalytosKavosPupeles += aparatai[i].produktai.getKavosPupeliuKiekis();
                isvalytasCukrus += aparatai[i].produktai.getCukrausKiekis();
            }

            System.out.println("Iš viso išalyta vandens " + isvalytasVanduo);
            System.out.println("Iš viso išvalyta kavos pupelių " + isvalytosKavosPupeles);
            System.out.println("Iš viso išvalyta cukraus " + isvalytasCukrus);
            return aparatai;
        }

        return null;
    }

    public List isvalykPaduotusAparatus(List<KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai) {
                isvalytasVanduo += k.produktai.getVandensKiekis();
                isvalytosKavosPupeles += k.produktai.getKavosPupeliuKiekis();
                isvalytasCukrus += k.produktai.getCukrausKiekis();
            }

            System.out.println("Iš viso išalyta vandens " + isvalytasVanduo);
            System.out.println("Iš viso išvalyta kavos pupelių " + isvalytosKavosPupeles);
            System.out.println("Iš viso išvalyta cukraus " + isvalytasCukrus);
            return aparatai;
        }

        return null;
    }

    public Map isvalykPaduotusAparatus(HashMap<Integer, KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai.values()) {
                isvalytasVanduo += k.produktai.getVandensKiekis();
                isvalytosKavosPupeles += k.produktai.getKavosPupeliuKiekis();
                isvalytasCukrus += k.produktai.getCukrausKiekis();
            }
            System.out.println("Iš viso išalyta vandens " + isvalytasVanduo);
            System.out.println("Iš viso išvalyta kavos pupelių " + isvalytosKavosPupeles);
            System.out.println("Iš viso išvalyta cukraus " + isvalytasCukrus);
            return aparatai;
        }

        return null;
    }

    //--------------------------------
    //Aparata isvalai vietoje plovimo, turbut turetu buti kvieciamas atlikPlovima metodas.
    public KavosAparatas isplaukPaduotaAparata(KavosAparatas kavosAparatas) {

        kavosAparatas.atlikPlovima();
        return kavosAparatas;

    }

    public KavosAparatas[] isplaukPaduotusAparatus(KavosAparatas[] aparatai) {

        if (aparatai != null) {
            for (int i = 0; i < aparatai.length; i++) {
                aparatai[i].atlikPlovima();
            }
            return aparatai;
        }
        return null;
    }

    public List isplaukPaduotusAparatus(List<KavosAparatas> aparatai) {

        if (aparatai != null) {
            for (KavosAparatas k : aparatai) {
                k.atlikPlovima();
            }
            return aparatai;
        }
        return null;
    }

    public Map isplaukPaduotusAparatus(HashMap<Integer, KavosAparatas> aparatai) {

        if (aparatai != null) {
            for (KavosAparatas k : aparatai.values()) {
                k.atlikPlovima();
            }
            return aparatai;
        }
        return null;
    }

    public KavosAparatas[] isvalykAparatuProduktus(KavosAparatas[] aparatai) {

        if (aparatai != null) {

            for (int i = 0; i < aparatai.length; i++) {
                aparatai[i].isvalykAparata();
            }
            return aparatai;
        }
        return null;
    }

    public List isvalykAparatuProduktus(List<KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai) {
                k.isvalykAparata();
            }
            return aparatai;
        }
        return null;
    }

    public Map isvalykAparatuProduktus(HashMap<Integer, KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai.values()) {
                k.isvalykAparata();
            }
        }
        return null;
    }

    public KavosAparatas[] priskirkTaPatiProdukta(KavosAparatas[] aparatai) {

        Produktai produktai = new Produktai(15, 15, 15);

        if (aparatai != null) {

            for (int i = 0; i < aparatai.length; i++) {
                aparatai[i].setProduktai(produktai);
            }
            return aparatai;
        }
        return null;
    }

    public List priskirkTaPatiProdukta(List<KavosAparatas> aparatai) {

        Produktai produktai = new Produktai(15, 15, 15);

        if (aparatai != null) {

            for (KavosAparatas k : aparatai) {
                k.setProduktai(produktai);
            }
            return aparatai;
        }
        return null;
    }

    public Map priskirkTaPatiProdukta(HashMap<Integer, KavosAparatas> aparatai) {

        Produktai produktai = new Produktai(15, 15, 15);

        if (aparatai != null) {

            for (KavosAparatas k : aparatai.values()) {
                k.setProduktai(produktai);
            }
            return aparatai;
        }
        return null;
    }

    public KavosAparatas[] priskirkNaujusProduktuObjektus(KavosAparatas[] aparatai) {

        if (aparatai != null) {

            for (int i = 0; i < aparatai.length; i++) {
                aparatai[i].setProduktai(new Produktai(7, 8, 9));
            }
            return aparatai;
        }
        return null;
    }

    public List priskirkNaujusProduktuObjektus(List<KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai) {
                k.setProduktai(new Produktai(7, 8, 9));
            }
            return aparatai;
        }
        return null;
    }

    public Map priskirkNaujusProduktuObjektus(HashMap<Integer, KavosAparatas> aparatai) {

        if (aparatai != null) {

            for (KavosAparatas k : aparatai.values()) {
                k.setProduktai(new Produktai(7, 8, 9));
            }
            return aparatai;
        }
        return null;
    }

}
