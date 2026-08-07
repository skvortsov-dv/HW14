package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getStringRepresentation() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}

