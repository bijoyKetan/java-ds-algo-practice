package oop.billsBurgers;

public class Main {

    public static void main(String[] args) throws Exception {
        Hamburger sampleHamburger = new Hamburger("White", "Beef", 5, "Base Burger");
        sampleHamburger.addItemToBurger("Carrot");
        sampleHamburger.addItemToBurger("Papaya");
        sampleHamburger.addItemToBurger("Tomatoes");
        sampleHamburger.addItemToBurger("Lettuce");


        double sampleHamburgerPrice = sampleHamburger.getFinalPrice();
        System.out.println("The final price of " + sampleHamburger.getBurgerName() + " is -> " + sampleHamburgerPrice);
        System.out.println(sampleHamburger);


        HealthyBurger sampleHealthyBurger = new HealthyBurger("Beef", 7,"HealthGuru");
        sampleHealthyBurger.addItemToBurger("Lettuce");
        sampleHealthyBurger.addItemToBurger("Carrot");
        sampleHealthyBurger.addItemToBurger("Onion");
        System.out.println("\nThe final price of this " + sampleHealthyBurger.getBurgerName() + " is -> " + sampleHealthyBurger.getFinalPrice());
    }
}
