package lt.vcs.karolis.kavosAparatas.servisas;

import lt.vcs.karolis.kavosAparatas.produktai.Produktai;
import lt.vcs.karolis.kavosAparatas.KavosAparatas;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by somka on 7/14/2017.
 */

    //===============Code review=================
    //Patikrinti ar paduodamas Kavos Aparatų masyvas yra ne null if (masyvas != null) {} else return null;
    // dėstytojas siūlė, kad aiškiau būtų vadinti masyvus "aparatai"

public class Servisas {
    private KavosAparatas[] aparatai;

    public Servisas(int aparatuSkaicius) {
        this.aparatai = new KavosAparatas[aparatuSkaicius];

        int i = 0;


        while (i < aparatuSkaicius) {
            aparatai[i] = new KavosAparatas(5, 5, 5);
            i++;
        }
    }

    public KavosAparatas[] getAparatuMasyvas() {
        return aparatai;
    }

    public KavosAparatas[] isvalykAparatus() {

        if (aparatai != null) {
            int isvalytaCukraus = 0;
            int isvalytaKavos = 0;
            int isvalytaVandens = 0;
            int isvalytaPieno = 0;
            int isvalytaSokolado = 0;
            System.out.println("Isvalyta: ");
            for (KavosAparatas aparatas : aparatai) {
                isvalytaCukraus += aparatas.produktai.getCukrausKiekis();
                isvalytaKavos += aparatas.produktai.getKavosKiekis();
                isvalytaVandens += aparatas.produktai.getVandensKiekis();
                isvalytaPieno += aparatas.produktai.getPienoKiekis();
                isvalytaSokolado += aparatas.produktai.getSokoladoKiekis();
                aparatas.produktai.setCukrausKiekis(0);
                aparatas.produktai.setKavosKiekis(0);
                aparatas.produktai.setVandensKiekis(0);
            }
            System.out.println("Cukraus: " + isvalytaCukraus);
            System.out.println("Kavos: " + isvalytaKavos);
            System.out.println("Vandens: " + isvalytaVandens);
        } else {
            return null;
        }

        return aparatai;
    }

    public void isplaukAparata(KavosAparatas aparatas) {
        aparatas.isplaukAparata();
    }

    public void isplaukVisusAparatus() {
        for(KavosAparatas aparatas : aparatai) {
            aparatas.isplaukAparata();
        }
    }

    public void atspausdinkAparatus() {
        aparatai[0].atspausdinkSukurtuAparatuSkaiciu();
        for(KavosAparatas aparatas : aparatai) {
            System.out.println(aparatas);
        }
        System.out.println();
    }

    public void priskirkTuosPaciusProduktus(Produktai produktai) {
        if (produktai != null) {
            for (KavosAparatas aparatas : aparatai) {
                aparatas.setProduktai(produktai);
            }
            System.out.println("Produktai priskirti!");
        } else {
            return;
        }
    }

    public void priskirkSkirtingusProduktus() {
        for(KavosAparatas aparatas : aparatai) {
            aparatas.setProduktai(new Produktai(getRandom(), getRandom(), getRandom(), getRandom(), getRandom()));
        }
        System.out.println("Produktai priskirti!");
    }

    private int getRandom() {
        int max = 10;
        int min = 0;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
