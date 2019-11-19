package oop.billsBurgers;

import java.util.ArrayList;
import java.util.List;

public class Hamburger {

    //    Bread roll type, meat and up to 4 additional additions
    private int itemCount;
    private String breadRollType;
    private String meatType;
    private double basePrice;
    private String burgerName;
    private List<String> additionalItems = new ArrayList<>();
    private double additionalItemPrice = 1.5;
    private double finalPrice;


    public Hamburger(String breadRollType, String meatType, int basePrice, String burgerName) {
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        this.basePrice = basePrice;
        this.burgerName = burgerName;
        this.itemCount = 0;
        this.finalPrice = basePrice;

    }

    public Hamburger() {
    }

    public void addItemToBurger(String burgerItem) throws Exception {
        if (itemCount >= 4) {
            throw new Exception("Cannot add more than 4 items");
        }
        itemCount++;
        additionalItems.add(burgerItem);
        finalPrice += additionalItemPrice;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "itemCount=" + itemCount +
                ", breadRollType='" + breadRollType + '\'' +
                ", meatType='" + meatType + '\'' +
                ", basePrice=" + basePrice +
                ", burgerName='" + burgerName + '\'' +
                ", additionalItems=" + additionalItems +
                ", additionalItemPrice=" + additionalItemPrice +
                ", finalPrice=" + finalPrice +
                '}';
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public List<String> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(List<String> additionalItems) {
        this.additionalItems = additionalItems;
    }

    public double getAdditionalItemPrice() {
        return additionalItemPrice;
    }

    public void setAdditionalItemPrice(double additionalItemPrice) {
        this.additionalItemPrice = additionalItemPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
