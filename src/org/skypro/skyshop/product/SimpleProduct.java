package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException("Некорректная цена");
        }

        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof SimpleProduct that)) return false;
//        if (!super.equals(o)) return false;
//        return price == that.price;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), price);
//    }
}
