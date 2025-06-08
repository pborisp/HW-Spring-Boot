package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService searchService;

    public SearchService(StorageService searchService) {
        this.searchService = new StorageService(searchService.getStorageProduct(), searchService.getStorageArticle());
    }

    public Set<Searchable> search(String searchterm) {
        Set<Searchable> searchRezult = searchService.getAll().stream()
                .filter(str -> str.getSearchTerm().contains(searchterm))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LongStringComparator())));
        return searchRezult;
    }
}
