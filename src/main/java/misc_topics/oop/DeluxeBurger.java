package misc_topics.oop;

import java.util.Arrays;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger(String breadRollType, String meatType, int basePrice, String burgerName) {
        super(breadRollType, meatType, basePrice, burgerName);
        super.setAdditionalItems(Arrays.asList("Chips", "Drink"));
    }

    @Override
    public void addItemToBurger(String burgerItem) throws Exception {
        throw new Exception("No new item can be added to Deluxeburger");
    }


}
