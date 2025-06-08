package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getTypeContent();

    UUID getId();

    default String getStringRepresentation(String s) {
        return getSearchTerm() + " " + getTypeContent();
    }
}
