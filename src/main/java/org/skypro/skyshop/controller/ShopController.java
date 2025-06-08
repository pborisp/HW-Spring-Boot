package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ShopController {
    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getStorageProduct().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getStorageArticle().values();
    }

    @GetMapping("/search")
    public Set<Searchable> getPattern(@RequestParam String pattern) {
        SearchService search = new SearchService(storageService);
        return search.search(pattern);
    }
}
