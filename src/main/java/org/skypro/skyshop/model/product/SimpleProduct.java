package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends org.skypro.skyshop.model.product.Product {
    private int price;
    private final UUID id;

    public SimpleProduct(String nameProduct, int price, UUID id) {
        super(nameProduct, id);
        try {
            definitionPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена не может быть меньше или равна 0");
        }
        this.price = price;
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + '\'' + " : " + price + " рублей";
    }
}