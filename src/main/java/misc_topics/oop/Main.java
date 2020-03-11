package misc_topics.oop;


public class Main {

    public static void main(String[] args) throws Exception {
        Hamburger sampleHamburger = new Hamburger("White", "Beef", 5, "Base Burger");
        sampleHamburger.addItemToBurger("Carrot");
        sampleHamburger.addItemToBurger("Papaya");
        sampleHamburger.addItemToBurger("Tomatoes");
        sampleHamburger.addItemToBurger("Lettuce");


        System.out.println(sampleHamburger.toString() + "\n");

        HealthyBurger sampleHealthyBurger = new HealthyBurger("Beef", 7,"HealthGuru");
        sampleHealthyBurger.addItemToBurger("Lettuce");
        sampleHealthyBurger.addItemToBurger("Carrot");
        sampleHealthyBurger.addItemToBurger("Onion");
        System.out.println(sampleHealthyBurger.toString());


    }
}
