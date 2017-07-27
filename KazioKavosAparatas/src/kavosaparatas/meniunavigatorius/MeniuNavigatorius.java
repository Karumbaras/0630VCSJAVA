package kavosaparatas.meniunavigatorius;

import kavosaparatas.aparatas.KavosAparatas;

import java.util.Scanner;

public class MeniuNavigatorius {

    private static Scanner sc = new Scanner(System.in);

    public static void paleistPrograma(KavosAparatas ka) {

        boolean programaVeikia = true;

        ka.atspausdinkPasirinkimuMeniu();

        do {

            int pasirinkimas = sc.nextInt();

            switch (pasirinkimas) {
                case 1:
                    ka.priimkUzsakyma("juoda");
                    break;
                case 2:
                    ka.priimkUzsakyma("cappucino");
                    break;
                case 3:
                    ka.priimkUzsakyma("machiatto");
                    break;
                case 4:
                    ka.papildykVandens();
                    break;
                case 5:
                    ka.papildykKavosPupeliu();
                    break;
                case 6:
                    ka.papildykCukraus();
                    break;
                case 7:
                    ka.papildykPieno();
                    break;
                case 8:
                    ka.arAparatasPasiruoses();
                    break;
                case 9:
                    ka.atlikPlovima();
                    break;
                case 0:
                    programaVeikia = false;
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nėra, bandykite dar kartą. \n");
                    break;
            }

            if (programaVeikia) {
                ka.atspausdinkPasirinkimuMeniu();
            }

        } while (programaVeikia);

        sc.close();

    }
}
