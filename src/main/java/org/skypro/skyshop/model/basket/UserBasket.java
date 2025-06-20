package org.skypro.skyshop.model.basket;

import java.util.*;

public class UserBasket {
    private final List<BasketItem> userBasket;
    int total;

    public List<BasketItem> getUserBasket() {
        return userBasket;
    }

    public int getTotal() {
        return total;
    }

    public UserBasket(List<BasketItem> basketItem) {
        this.userBasket = basketItem;
        total = basketItem.stream()
                .mapToInt(i -> i.getBasketItem().getPrice() * i.getCount())
                .sum();
    }
}
