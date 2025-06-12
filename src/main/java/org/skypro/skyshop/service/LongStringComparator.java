package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Comparator;


public class LongStringComparator implements Comparator<Searchable> {

    public int compare(Searchable o1, Searchable o2) {
        Integer sizeName1, sizeName2;
        sizeName1 = o1.getSearchTerm().length();
        sizeName2 = o2.getSearchTerm().length();
        if (sizeName1 == sizeName2) {
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }
        return sizeName2.compareTo(sizeName1);
    }
}
