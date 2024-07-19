package service;

import model.Item;
import model.Promotion;

import java.util.List;

public class BillingService {
    private PromotionService promotionService = new PromotionService();

    public double calculateSubtotal(List<Item> items) {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public void applyPromotions(List<Item> items, List<Promotion> promotions) {
        promotionService.applyPromotions(items, promotions);
    }

    public double calculateTax(double amount, double taxRate) {
        return amount * taxRate;
    }
}
