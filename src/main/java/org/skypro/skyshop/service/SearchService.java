package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final StorageService searchService;

    public SearchService(StorageService storageService) {
        this.searchService = storageService;
    }

    public List<Searchable> search(String query) {
        String queryLower = query.toLowerCase();
        return searchService.getAll().stream()
                .filter(str -> str.getSearchTerm().toLowerCase()
                        .contains(queryLower)).toList();
    }
}
