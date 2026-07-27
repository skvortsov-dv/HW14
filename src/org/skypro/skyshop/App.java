package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.add(new SimpleProduct("Стол", 2000));
        productBasket.add(new SimpleProduct("Стул", 1000));
        productBasket.add(new DiscountedProduct("Хлеб", 50, 20));
        productBasket.add(new DiscountedProduct("Молоко", 100, -50));
        productBasket.add(new FixPriceProduct("Лицензия"));


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

