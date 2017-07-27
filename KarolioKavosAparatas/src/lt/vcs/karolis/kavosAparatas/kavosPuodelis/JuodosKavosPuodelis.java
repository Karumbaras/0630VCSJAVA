package lt.vcs.karolis.kavosAparatas.kavosPuodelis;

import lt.vcs.karolis.kavosAparatas.produktai.Produktai;

/**
 * Created by karolis somka on 7/19/2017.
 */

    //============Code Review==============
    //Dar vienas būdas, kuriant naujus Kavos Puodelių objektus - tai Tėvinėje klasėje sukurti konstruktorių,
    // kuris kurtų Kavos puodelį su "super" kreipiniu bei paduotu kavos pavadinimu ir paduotais produktais

public class JuodosKavosPuodelis extends KavosPuodelis {

    public JuodosKavosPuodelis() {
        super("Juoda", new Produktai(2, 2, 2));
    }
}
