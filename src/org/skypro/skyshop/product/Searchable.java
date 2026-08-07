package org.skypro.skyshop.product;

public interface Searchable {
    default String getStringRepresentation() {
        return getName() + " - " + getType();
    }

    String getType();

    String getName();
}
