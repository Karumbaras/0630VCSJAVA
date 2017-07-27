package kavosaparatas;

import kavosaparatas.aparatas.KavosAparatas;
import kavosaparatas.exceptions.ReikiaValytiAparata;
import kavosaparatas.exceptions.TrukstaProduktu;
import kavosaparatas.meniunavigatorius.MeniuNavigatorius;

public class Main {

    public static void main(String[] args) {

            MeniuNavigatorius.paleistPrograma(new KavosAparatas(5, 5, 5));

    }
}
