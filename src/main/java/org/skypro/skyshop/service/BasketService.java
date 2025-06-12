package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket basketService;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket basketService, StorageService storageService) {
        this.basketService = basketService;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        storageService.getProductById(id).orElseThrow(() -> new IllegalArgumentException());
        basketService.addProductToBasket(id);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = basketService.getBasket();
        List<BasketItem> userBasket = basketMap.entrySet().stream()
                .map(map -> new BasketItem(storageService.getProductById(map.getKey()).orElseThrow(), map.getValue()))
                .collect(Collectors.toCollection(() -> new ArrayList<BasketItem>()));
        return new UserBasket(userBasket);
    }
}
