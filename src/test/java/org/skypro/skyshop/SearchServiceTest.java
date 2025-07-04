package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void givenStorageService_WhenStorageServiceNotFind_ThenReturnIsNull() {
        Mockito.when(storageService.getAll()).thenReturn(Collections.emptyList());

        boolean result = searchService.search("test").isEmpty();

        Assertions.assertEquals(true, result);
    }

    @Test
    void givenObjectsWhenSearchResultIsNullThenOk() {
        Mockito.when(searchService.search("test")).thenReturn(Collections.emptyList());

        List<Searchable> result = searchService.search("test");

        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    void givenObjectsWhenSearchNotIsNullThenOk() {
        Product table = new SimpleProduct("Стол", 15000, UUID.randomUUID());
        List<Searchable> test = new ArrayList<>();
        test.add(table);
        Mockito.when((storageService.getAll())).thenReturn(test);

        List<Searchable> result = searchService.search("Стол");

        Assertions.assertEquals(test, result);
    }
}
