package test;

import model.Item;
import model.Promotion;
import org.junit.Before;
import org.junit.Test;
import service.BillingService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BillingServiceTest {
    private BillingService billingService;
    private List<Item> items;
    private List<Promotion> promotions;

    @Before
    public void setUp() {
        billingService = new BillingService();
        items = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    @Test
    public void testCalculateSubtotal() {
        items.add(new Item("Milk", 2, 1.50));
        items.add(new Item("Bread", 3, 2.00));
        double subtotal = billingService.calculateSubtotal(items);
        assertEquals(9.0, subtotal, 0.01);
    }

    @Test
    public void testApplyPromotions() {
        items.add(new Item("Milk", 2, 1.50));
        items.add(new Item("Bread", 3, 2.00));
        promotions.add(new Promotion("buy-one-get-one-free", "Milk", 0, 1, 1));
        promotions.add(new Promotion("percentage-off", "Bread", 0.10, 0, 0));

        billingService.applyPromotions(items, promotions);
        double discountedSubtotal = billingService.calculateSubtotal(items);

        assertEquals(1.50, items.get(0).getTotalPrice(), 0.01);
        assertEquals(5.40, items.get(1).getTotalPrice(), 0.01);
        assertEquals(6.90, discountedSubtotal, 0.01);
    }

    @Test
    public void testCalculateTax() {
        double tax = billingService.calculateTax(6.90, 0.05);
        assertEquals(0.35, tax, 0.01);
    }
}
