package main;

import model.Item;
import model.Promotion;
import service.BillingService;
import util.InputParser;

import java.util.List;
import java.util.Scanner;

public class GroceryStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Item> items = InputParser.parseItems(scanner);
        List<Promotion> promotions = InputParser.parsePromotions(scanner);
        double taxRate = InputParser.parseTaxRate(scanner);
        
        BillingService billingService = new BillingService();
        
        double subtotal = billingService.calculateSubtotal(items);
        billingService.applyPromotions(items, promotions);
        
        double discountedSubtotal = billingService.calculateSubtotal(items);
        double tax = billingService.calculateTax(discountedSubtotal, taxRate);
        double total = discountedSubtotal + tax;

        for (Item item : items) {
            System.out.printf("%s: %.2f\n", item.getName(), item.getTotalPrice());
        }

        System.out.printf("Subtotal: %.2f\n", discountedSubtotal);
        System.out.printf("Tax: %.2f\n", tax);
        System.out.printf("Total: %.2f\n", total);
    }
}
