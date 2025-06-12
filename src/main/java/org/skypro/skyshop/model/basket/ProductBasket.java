package org.skypro.skyshop.model.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productBasket;

    @Autowired
    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    public void addProductToBasket(UUID id) {
        if (productBasket.containsKey(id)) {
            this.productBasket.put(id, (this.productBasket.get(id).intValue() + 1));
        } else {
            this.productBasket.put(id, 1);
        }
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}
