package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 4500;
    private final UUID id;

    public FixPriceProduct(String nameProduct, UUID id) {
        super(nameProduct);
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                " : фиксированная цена " + fixPrice + " рублей!!!";
    }
}
