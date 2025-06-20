package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {
    private final Product basketItem;
    int count;

    public BasketItem(Product basketItem, int count) {
        this.basketItem = basketItem;
        this.count = count;
    }

    public Product getBasketItem() {
        return basketItem;
    }

    public int getCount() {
        return count;
    }
}
