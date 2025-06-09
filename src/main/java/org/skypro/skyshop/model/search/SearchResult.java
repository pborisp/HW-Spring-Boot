package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(String name, UUID id, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }


    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getSearchTerm(), searchable.getId(), searchable.getTypeContent());
    }

}
