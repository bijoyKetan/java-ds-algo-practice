package oop.billsBurger;

import oop.billsBurgers.Hamburger;
import org.junit.Assert;
import org.junit.Test;


public class Tester {

    @Test
    public void burgertester() {
        Hamburger testBurger = new Hamburger("White", "Beef", 5, "Awesome Burger");
        Assert.assertTrue(testBurger.getBasePrice() == 5);
        Assert.assertTrue(testBurger.getFinalPrice() == 5);
    }

    @Test
    public void testFinalPriceHamburger() throws Exception {
        Hamburger testBurger2 = new Hamburger("White", "Beef", 5, "Awesome Burger");
        testBurger2.addItemToBurger("Carrot");
        testBurger2.addItemToBurger("Cucumber");
        testBurger2.addItemToBurger("Lettuce");
        Assert.assertTrue(testBurger2.getFinalPrice() == testBurger2.getBasePrice() + testBurger2.getAdditionalItemPrice()*3);


    }
}
