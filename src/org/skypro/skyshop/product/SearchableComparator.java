package org.skypro.skyshop.product;

import java.util.Comparator;

public class SearchableComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Searchable s1 = (Searchable) o1; 
        Searchable s2 = (Searchable) o2;
//        s2 s2 = (s2) o;

        int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());

        if (lengthCompare == 0){
            return s1.getName().compareTo(s2.getName());
        }

        return lengthCompare;
    }
}
