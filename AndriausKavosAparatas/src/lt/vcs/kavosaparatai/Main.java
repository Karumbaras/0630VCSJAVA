package lt.vcs.kavosaparatai;

import lt.vcs.kavosaparatai.aparatai.KavosAparatas;
import lt.vcs.kavosaparatai.puodeliai.KavosPuodelis;
import lt.vcs.kavosaparatai.resursai.Produktai;
import lt.vcs.kavosaparatai.servisai.KavosAparatuServisas;


// Linkejimai visiems!
// Main klasë kurioje bandau naudoti kavos aparatus
public class Main {

    // Metodas kuris padetu atskirti aparato metodu atspausdinamus rezultatus
    private static void spausdinkSkirtuka() {
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {

        KavosPuodelis p = new KavosAparatas().gaminkKava("normali");

        System.out.println(p);

      

    }
}
