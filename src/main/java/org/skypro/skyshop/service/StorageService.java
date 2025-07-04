package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct;
    private final Map<UUID, Article> storageArticle;

    public StorageService() {
        this.storageProduct = new HashMap<>();
        this.storageArticle = new HashMap<>();
        addProduct();
    }

    public Collection<Product> getStorageProduct() {
        return Collections.unmodifiableCollection(storageProduct.values());
    }

    public Collection<Article> getStorageArticle() {
        return Collections.unmodifiableCollection(storageArticle.values());
    }

    public List<Searchable> getAll() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(storageProduct.values());
        result.addAll(storageArticle.values());
        return result;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(storageProduct.get(id));
    }

    private void addProduct() {
        Product table = new SimpleProduct("Стол", 15000, UUID.randomUUID());
        this.storageProduct.put(table.getId(), table);
        Product chair = new SimpleProduct("Стулллллллллллл", 7000, UUID.randomUUID());
        this.storageProduct.put(chair.getId(), chair);
        Product tv = new SimpleProduct("телевизор 2025", 75000, UUID.randomUUID());
        this.storageProduct.put(tv.getId(), tv);
        Product phone = new DiscountedProduct("телефон", 90000, 30, UUID.randomUUID());
        this.storageProduct.put(phone.getId(), phone);
        Product sofa = new DiscountedProduct("диван", 49000, 25, UUID.randomUUID());
        this.storageProduct.put(sofa.getId(), sofa);
        Product lamp = new FixPriceProduct("1светильник2025", UUID.randomUUID());
        this.storageProduct.put(lamp.getId(), lamp);
        Product soundbar = new DiscountedProduct("колонка", -17000, 15, UUID.randomUUID());
        this.storageProduct.put(soundbar.getId(), soundbar);
        Product bed = new SimpleProduct("c", 34000, UUID.randomUUID());
        this.storageProduct.put(bed.getId(), bed);
        Product test = new SimpleProduct("ст стстстстстстстстсст", 200, UUID.randomUUID());
        this.storageProduct.put(test.getId(), test);
        Article weather = new Article("Погода март 2025 ", " Погода в этом году в марте как в мае!", UUID.randomUUID());
        this.storageArticle.put(weather.getId(), weather);
        Article set = new Article(" Комплект мебели со стулом", " Комплектом покупать всегда выгоднее: стол + стул + диван", UUID.randomUUID());
        this.storageArticle.put(set.getId(), set);
    }
}