package coffeeCups;

import coffeeMainPack.CoffeeProducts;

public class CoffeeCup extends Cup {

    CoffeeProducts products;
    private String name;
    private boolean isDone = false;
    public static int coffeesMade = 0;

    public CoffeeCup(int cukrus, int pupeles, int vanduo, String pavadinimas) { //arba viskas angliškai arba lietuviškai
        products = new CoffeeProducts(cukrus, pupeles, vanduo);
        this.name = pavadinimas;
    }

    public CoffeeCup CopyOfCoffeeCup(CoffeeCup cup) {
        return new CoffeeCup(this.getSugar(), this.getBeans(), this.getWater(), this.name);
    }

    @Override
    public String toString() {

        String amounts = "Sugar: " + products.getCukrus() + " Pupeles: " + products.getPupeles() + " Vanduo: "
                + products.getVanduo();
        return name + " " + amounts + " " + isDone;
    }

    public int getSugar() {
        return products.getCukrus();
    }

    public int getWater() {
        return products.getVanduo();
    }

    public int getBeans() {
        return products.getPupeles();
    }

    public String getName() {
        return name;
    }

    public void setStatusDone() {
        isDone = true;
    }

    public boolean coffeeStatus() {
        return isDone;

    }

    public void thisCoffeeMade() {

    }

}
