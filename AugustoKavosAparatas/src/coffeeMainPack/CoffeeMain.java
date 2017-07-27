package coffeeMainPack;

public class CoffeeMain {

    public static void main(String[] args) throws OutOfProducts, TimeToClean {

    	// komentaras
        Aptarnavimas aptarnavimasObject = new Aptarnavimas(1);
        CoffeeMachine manoAparatas = aptarnavimasObject.getAparatai(0);

        while (true) {
            try {
                manoAparatas.meniu();
                aptarnavimasObject.jeiguReikiaIsvalyk(manoAparatas);
                aptarnavimasObject.issaukMeniu(manoAparatas);
                aptarnavimasObject.replenishIngredients(manoAparatas);

            } catch (OutOfProducts | TimeToClean ep) {
                System.err.println("MESSAGE: " + ep.getMessage());
                ep.printStackTrace();
            }
        }

    }
}
