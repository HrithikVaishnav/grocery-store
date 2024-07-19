package service;

import model.Item;
import model.Promotion;

import java.util.List;

public class PromotionService {
    public void applyPromotions(List<Item> items, List<Promotion> promotions) {
        for (Promotion promotion : promotions) {
            for (Item item : items) {
                if (item.getName().equals(promotion.getItemName())) {
                    switch (promotion.getType()) {
                        case "buy-one-get-one-free":
                            applyBuyOneGetOneFree(item, promotion);
                            break;
                        case "percentage-off":
                            double discountPercentage = promotion.getDiscount();
                            double discountAmount = item.getTotalPrice() * discountPercentage;
                            item.setPrice(item.getPrice() - (discountAmount / item.getQuantity()));
                            break;
                    }
                }
            }
        }
    }

    private void applyBuyOneGetOneFree(Item item, Promotion promotion) {
        int applicablePairs = item.getQuantity() / (promotion.getBuyQuantity() + promotion.getFreeQuantity());
        int freeItems = applicablePairs * promotion.getFreeQuantity();
        double totalItemsToPayFor = item.getQuantity() - freeItems;
        double discountedPrice = totalItemsToPayFor * item.getPrice();
        item.setQuantity(item.getQuantity()); 
        item.setPrice(item.getPrice());
        item.setTotalPrice(discountedPrice);
    }
}
