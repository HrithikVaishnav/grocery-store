package model;

public class Promotion {
    private String type;
    private String itemName;
    private double discount;
    private int buyQuantity;
    private int freeQuantity;

    public Promotion(String type, String itemName, double discount, int buyQuantity, int freeQuantity) {
        this.type = type;
        this.itemName = itemName;
        this.discount = discount;
        this.buyQuantity = buyQuantity;
        this.freeQuantity = freeQuantity;
    }

    public String getType() {
        return type;
    }

    public String getItemName() {
        return itemName;
    }

    public double getDiscount() {
        return discount;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }
}
