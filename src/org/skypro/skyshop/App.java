package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.add(new Product("Стол", 2000));
        productBasket.add(new Product("Стул", 1000));
        productBasket.add(new Product("Шкаф", 2500));
        productBasket.add(new Product("Тумбочка", 800));
        productBasket.add(new Product("Полка", 500));
        productBasket.add(new Product("Люстра", 3000));

        productBasket.print();
        System.out.println(productBasket.sum());
        System.out.println(productBasket.contains("Шкаф"));
        System.out.println(productBasket.contains("Лампочка"));

        productBasket.clear();
        productBasket.print();
        System.out.println(productBasket.sum());
        System.out.println(productBasket.contains("Шкаф"));
    }
}

