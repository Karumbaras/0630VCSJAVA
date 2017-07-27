package lt.vcs.karolis.kavosAparatas;

import lt.vcs.karolis.kavosAparatas.UI.AparatoUI;
import lt.vcs.karolis.kavosAparatas.kavosPuodelis.KavosPuodelis;
import lt.vcs.karolis.kavosAparatas.servisas.Servisas;

public class Main {

    // ==================Code Review===================
    // 1. Iškelti atskirai Kavos aparato projektą
    //


    public static void main(String[] args) {
        KavosAparatas aparatas = new KavosAparatas(0, -5, 10, 5);
        aparatas.paruoskKavos("juoda");

    }
}
