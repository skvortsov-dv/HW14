package org.skypro.skyshop.product;

import java.util.Objects;

public class FixPriceProduct extends Product {
    private static final int PRICE = 1000;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FixPriceProduct.PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Product product)) return false;
//        return super.equals(product);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
