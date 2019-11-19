package oop.billsBurgers;

import java.util.ArrayList;
import java.util.List;


public final class HealthyBurger extends Hamburger {

    private int healthyItemCount = 0;
    private List<String> additionalHealthyItems = new ArrayList<>();


    public HealthyBurger(String healthyMeatType, int healthyBasePrice, String healthyBurgerName) {
        super("Brown Rye", healthyMeatType, healthyBasePrice, healthyBurgerName);
        super.setFinalPrice(healthyBasePrice);
    }


    @Override
    public void addItemToBurger(String burgerItem) throws Exception {
        if (healthyItemCount >= 6) throw new Exception("Cannot add more than 6 items in healthy burger! ");
        healthyItemCount++;
        additionalHealthyItems.add(burgerItem);
        super.setFinalPrice(super.getFinalPrice() + super.getAdditionalItemPrice());
    }


}