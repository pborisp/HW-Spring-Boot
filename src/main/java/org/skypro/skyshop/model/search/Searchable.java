package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getTypeContent();

    UUID getId();

//    default String getStringRepresentation() {
//        return getSearchTerm() + " " + getTypeContent();
//    }
}