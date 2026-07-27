package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class ProductBasket {
    private Product[] products;
    private int index;

    public ProductBasket() {
        this.products = new Product[5];
        this.index = 0;
    }

    public void add(Product product) {
        if (index >= 5) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[index++] = product;
    }

    public int sum() {
        int sum = 0;

        for (int i = 0; i < index; i++) {
            sum += products[i].getPrice();
        }

        return sum;
    }

    public void print() {
        if (index != 0) {
            int special = 0;

            for (int i = 0; i < index; i++) {
                if (products [i].isSpecial()) {
                    special += 1;
                }
                System.out.println(products[i]);
            }

            System.out.println("Итого: " + sum());
            System.out.println("Специальных товаров: " + special);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean contains(String name) {
        for (int i = 0; i < index; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }

        index = 0;
    }
}
