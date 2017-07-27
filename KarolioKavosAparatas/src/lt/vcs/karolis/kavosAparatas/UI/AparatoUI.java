package lt.vcs.karolis.kavosAparatas.UI;

import lt.vcs.karolis.kavosAparatas.produktai.Produktai;
import lt.vcs.karolis.kavosAparatas.servisas.Servisas;

import java.util.Scanner;

/**
 * Created by somka on 7/16/2017.
 */
public class AparatoUI {
    private Scanner reader;
    private int pasirinkimas;
    private Servisas servisas;
    private int aparatuSkaicius;
    private String pasirinkimasText;
    private int aparatoNumeris;

    public AparatoUI() {
        reader = new Scanner(System.in);
        pasirinkimas = 0;
        pasirinkimasText = "";
    }

    public void start() {
        System.out.println("Kavos aparatu tinklas ijungtas.");
        System.out.println("Kiek aparatu bus reikalingi?");
        aparatuSkaicius = nuskaitykInt(reader);
        servisas = new Servisas(aparatuSkaicius);
        while (true) {
            servisoMeniu();
            if (pasirinkimas == 0) {
                break;
            }
        }
        System.out.println("Sistema isjungiama");
        System.out.println("Naudoti kavos aparatai: ");
        servisas.atspausdinkAparatus();
    }

    private void servisoMeniu(){
        System.out.println("Galimi veiksmai: " +
                "1.Pagaminti kavos " +
                "2.Isvalyti aparatus " +
                "3.Isplauti aparatus " +
                "4.Papildyti produktu " +
                "5.Atspausdinti aparatu info " +
                "0.Baigti");
        pasirinkimas = nuskaitykInt(reader);
        switch (pasirinkimas) {
            case 1:
                meniuKavosAparatams(reader);
                break;
            case 2:
                servisas.isvalykAparatus();
                break;
            case 3:
                meniuPlovimui(reader);
                break;
            case 4:
                meniuProduktams();
                break;
            case 5:
                servisas.atspausdinkAparatus();
            case 0:
                break;
            default:
                System.out.println("Ivestas neteisingas pasirinkimas.");
                break;
        }
    }

    private void meniuKavosAparatams(Scanner reader){
        System.out.println("Kuriuo aparatu ruosime kava? ");
        pasirinkimas = nuskaitykInt(reader);
        if (pasirinkimas < 0 || pasirinkimas > aparatuSkaicius) {
            System.out.println("Pasirinktas neteisingas aparatas.");
        } else {
             meniuKavai(pasirinkimas - 1, reader);
        }
    }

    private void meniuKavai(int aparatoNumeris, Scanner reader) {
        System.out.println("Kokia kava ruosime? ");
        System.out.println("Galimi pasirinkimai: " +
                "Juoda,  " +
                "Espresso,  " +
                "Americano,  ");
        pasirinkimasText = nuskaitykString(reader);
        servisas.getAparatuMasyvas()[aparatoNumeris].paruoskKavos(pasirinkimasText.toLowerCase());
    }

    private void meniuPlovimui(Scanner reader) {
        while (true) {
            System.out.println("Ka plausime? " +
                    "1. Visus aparatus; " +
                    "2. Viena aparata; " +
                    "0. Grizti. ");
            int pasirinkimas = nuskaitykInt(reader);
            if (pasirinkimas == 1) {
                servisas.isplaukVisusAparatus();
                System.out.println("Aparatai isplauti!");
            } else if (pasirinkimas == 2) {
                System.out.println("Kuri aparata plausime?");
                aparatoNumeris = nuskaitykInt(reader);
                if (aparatoNumeris < 0 || aparatoNumeris > aparatuSkaicius) {
                    System.out.println("Pasirinktas neteisingas aparatas.");
                } else {
                    servisas.isplaukAparata(servisas.getAparatuMasyvas()[aparatoNumeris - 1]);
                }
            } else if (pasirinkimas == 0) {
                break;
            } else {
                System.out.println("Pasirinkta neteisingai.");
            }
        }
    }

    private void meniuProduktams(){
        System.out.println("Galimi pasirinkimai: " +
                "1. Priskirti tuos pacius produktus; " +
                "2. Priskirti skirtingus produktus; " +
                "3. Papildyti kazkurio produkto; " +
                "0. Grizti. ");
        pasirinkimas = nuskaitykInt(reader);
        switch (pasirinkimas) {
            case 1:
                System.out.println("Kiek cukraus priskirsime? ");
                int cukrausKiekis = nuskaitykInt(reader);
                System.out.println("Kiek kavos priskirsime? ");
                int kavosKiekis = nuskaitykInt(reader);
                System.out.println("Kiek vandens priskirsime? ");
                int vandensKiekis = nuskaitykInt(reader);
                Produktai produktai = new Produktai(cukrausKiekis, kavosKiekis, vandensKiekis);
                servisas.priskirkTuosPaciusProduktus(produktai);
                break;
            case 2:
                servisas.priskirkSkirtingusProduktus();
                break;
            case 3:
                System.out.println("Kuri aparata papildysime? ");
                aparatoNumeris = nuskaitykInt(reader);
                System.out.println("Kurio produkto papildysime? ");
                pasirinkimasText = nuskaitykString(reader);
                switch (pasirinkimasText.toLowerCase()) {
                    case "cukraus":
                        servisas.getAparatuMasyvas()[aparatoNumeris - 1].papildykCukraus(kiekPapildysime());
                        break;
                    case "kavos":
                        servisas.getAparatuMasyvas()[aparatoNumeris - 1].papildykKavos(kiekPapildysime());
                        break;
                    case "vandens":
                        servisas.getAparatuMasyvas()[aparatoNumeris - 1].papildykVandens(kiekPapildysime());
                        break;
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pasirinkta neteisingai.");
                break;
        }
    }

    private int nuskaitykInt(Scanner reader) {
        return reader.nextInt();
    }

    private String nuskaitykString(Scanner reader) {
        return reader.next();
    }

    private int kiekPapildysime() {
        System.out.println("Iveskite kieki? ");
        int papildymoKiekis = nuskaitykInt(reader);
        return papildymoKiekis;
    }
}
