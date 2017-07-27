package lt.vcs.karolis.kavosAparatas;

import lt.vcs.karolis.kavosAparatas.UI.AparatoUI;
import lt.vcs.karolis.kavosAparatas.kavosPuodelis.KavosPuodelis;
import lt.vcs.karolis.kavosAparatas.servisas.Servisas;

public class Main {

    // ==================Code Review===================
    // 1. Iškelti atskirai Kavos aparato projektą
    //

// Hello
    public static void main(String[] args) {
        KavosAparatas aparatas = new KavosAparatas(10, 10, 10, 10, 5);
        aparatas.paruoskKavos("juoda");

    }
}
