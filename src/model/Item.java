package model;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private double totalPrice;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = quantity * price; 
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        updateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private void updateTotalPrice() {
        this.totalPrice = this.quantity * this.price;
    }
}
