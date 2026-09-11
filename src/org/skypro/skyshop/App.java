package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Стол", 2000);
        Product product2 = new SimpleProduct("Стул", 1000);
        Product product3 = new DiscountedProduct("Хлеб", 50, 20);
        Product product4 = new DiscountedProduct("Молоко", 100, -50);
        Product product5 = new FixPriceProduct("Лицензия");


        productBasket.add(product1);
        productBasket.add(product2);
        productBasket.add(product3);
        productBasket.add(product4);
        productBasket.add(product5);


        productBasket.print();
        System.out.println(productBasket.sum());
        System.out.println(productBasket.contains("Шкаф"));
        System.out.println(productBasket.contains("Лампочка"));

        productBasket.clear();
        productBasket.print();
        System.out.println(productBasket.sum());
        System.out.println(productBasket.contains("Шкаф"));

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);

        System.out.println(Arrays.toString(searchEngine.search("Хлеб")));

        System.out.println(Arrays.toString(searchEngine.search("Ст")));

        try {
            Product simpleProduct1 = new SimpleProduct("", 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product simpleProduct2 = new SimpleProduct("Лампа", -150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct1 = new DiscountedProduct("", 70, 25);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct2 = new DiscountedProduct("Свечи", -200, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct3 = new DiscountedProduct("Цветы", 100, -10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct4 = new DiscountedProduct("Мебель", 10000, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product fixPriceProduct1 = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.getSearchTerm("о"));
            System.out.println(searchEngine.getSearchTerm("ааааа"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}



