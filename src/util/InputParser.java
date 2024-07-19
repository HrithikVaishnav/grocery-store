package util;

import model.Item;
import model.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    public static List<Item> parseItems(Scanner scanner) {
        List<Item> items = new ArrayList<>();
        System.out.println("Enter item details (name, quantity, price). Press Enter twice to finish:");
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;

            String[] parts = line.split(",");
            String name = parts[0].split(":")[1].trim().replaceAll("\"", "");
            int quantity = Integer.parseInt(parts[1].split(":")[1].trim());
            double price = Double.parseDouble(parts[2].split(":")[1].trim());

            items.add(new Item(name, quantity, price));
        }
        return items;
    }

    public static List<Promotion> parsePromotions(Scanner scanner) {
        List<Promotion> promotions = new ArrayList<>();
        System.out.println("Enter promotions (type, item name, discount). Press Enter twice to finish:");
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;

            String[] parts = line.split(":");
            String type = parts[0].trim();
            String itemName = parts[1].trim().split(",")[0].trim();
            double discount = 0;
            int buyQuantity = 0;
            int freeQuantity = 0;

            if (type.equals("percentage-off")) {
                discount = Double.parseDouble(parts[1].split(",")[1].trim().replace("% off", "")) / 100;
            } else if (type.equals("buy-one-get-one-free")) {
                buyQuantity = 1;
                freeQuantity = 1;
            }

            promotions.add(new Promotion(type, itemName, discount, buyQuantity, freeQuantity));
        }
        return promotions;
    }

    public static double parseTaxRate(Scanner scanner) {
        System.out.println("Enter tax rate:");
        return Double.parseDouble(scanner.nextLine().trim()) / 100;
    }
}
