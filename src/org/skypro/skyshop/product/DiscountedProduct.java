package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public int getDiscount() {
        return discount;
    }

    public DiscountedProduct(String name, int price, int discount) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException("Некорректная цена");
        }

        if (discount < 0 && discount > 100) {
            throw new IllegalArgumentException("Некорректная скидка");
        }

        this.price = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "(" + getDiscount() + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
