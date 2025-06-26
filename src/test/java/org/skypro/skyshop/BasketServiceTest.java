package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.NoSuchProductException;
import org.skypro.skyshop.service.StorageService;
import java.util.*;

import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void givenProductIsNull_whenAddProduct_thenThrowNoSuchProductException() {
        UUID id = randomUUID();
        Mockito.when(storageService.getProductById(any(UUID.class))).thenThrow(NoSuchProductException.class);
        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addProduct(id));
    }

    @Test
    void givenProduct_whenAddProduct_thenOk() {
        //given
        UUID id = randomUUID();
        Product table = new SimpleProduct("Стол", 15000, id);
        Map<UUID, Product> test = new HashMap<>();
        test.put(id, table);
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.ofNullable(test.get(id)));
        //when
        basketService.addProduct(id);
        //then
        Mockito.verify(productBasket, Mockito.times(1)).addProductToBasket(id);
    }

    @Test
    void givenProductBasketIsNull_whenGetUserBasket_thenBasketIsNull() {
        Mockito.when(productBasket.getBasket()).thenReturn(Collections.emptyMap());
        UserBasket result = basketService.getUserBasket();
        Assertions.assertEquals(null, result);
    }

    @Test
    void givenProductBasketFull_whenGetUserBasket_thenReturnBasket() {
        //given
        UUID id = randomUUID();
        Product table = new SimpleProduct("Стол", 15000, id);
        Map<UUID, Product> test = new HashMap<>();
        test.put(id, table);
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.ofNullable(test.get(id)));
        productBasket.addProductToBasket(id);
        basketService.addProduct(id);
        //when
        UserBasket basket = basketService.getUserBasket();
        //then
        Assertions.assertNull(basket);
    }
}
