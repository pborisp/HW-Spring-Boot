package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;


    public DiscountedProduct(String nameProduct, int basePrice, int discount, UUID id) {
        super(nameProduct, id);
        try {
            definitionBasePrice(basePrice);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена не может быть меньше или равна 0");
        }
        this.basePrice = basePrice;
        try {
            definitionDiscount(discount);
        } catch (IllegalArgumentException e) {
            System.out.println("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * discount / 100;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                " : " + getPrice() + " рублей" + " с учетом cкидки " + discount + "%";
    }
}