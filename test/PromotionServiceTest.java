package test;

import java.io.Console;
import model.Item;
import model.Promotion;
import org.junit.Before;
import org.junit.Test;
import service.PromotionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PromotionServiceTest {
    private PromotionService promotionService;
    private List<Item> items;
    private List<Promotion> promotions;

    @Before
    public void setUp() {
        promotionService = new PromotionService();
        items = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    @Test
    public void testApplyBuyOneGetOneFreePromotion() {
        items.add(new Item("Milk", 2, 1.50));
        promotions.add(new Promotion("buy-one-get-one-free", "Milk", 0, 1, 1));
        
        promotionService.applyPromotions(items, promotions);
        System.out.println("Total Price for Milk: " + items.get(0).getTotalPrice());

        assertEquals(1.50, items.get(0).getTotalPrice(), 0.01);
    }

    @Test
    public void testApplyPercentageOffPromotion() {
        items.add(new Item("Bread", 3, 2.00));
        promotions.add(new Promotion("percentage-off", "Bread", 0.10, 0, 0));
        
        promotionService.applyPromotions(items, promotions);
        
        assertEquals(5.40, items.get(0).getTotalPrice(), 0.01);
    }
}
