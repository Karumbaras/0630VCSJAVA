package KavosAparatas3.src.lt.vcs.kavosaparatai;

import KavosAparatas3.src.lt.vcs.kavosaparatai.aparatai.KavosAparatas;
import KavosAparatas3.src.lt.vcs.kavosaparatai.puodeliai.KavosPuodelis;



public class Main {

    
    private static void spausdinkSkirtuka() {
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {

        KavosPuodelis p = new KavosAparatas().gaminkKava("");

        System.out.println(p);

      

    }
}
