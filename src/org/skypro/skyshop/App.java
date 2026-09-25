package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Стол", 2000);
        Product product2 = new SimpleProduct("Стул", 1000);
        Product product3 = new DiscountedProduct("Хлеб", 50, 20);
        Product product4 = new DiscountedProduct("Молоко", 100, 0);
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

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);

        System.out.println(searchEngine.search("Хлеб"));

        System.out.println(searchEngine.search("Ст"));

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
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(searchEngine.getSearchTerm("ааааа"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        ProductBasket productBasket2 = new ProductBasket();

        productBasket2.add(product1);
        productBasket2.add(product2);
        productBasket2.add(product3);
        productBasket2.add(product4);
        productBasket2.add(product5);
        productBasket2.add(product1);

        List<Product> deleted = productBasket2.remove("Стол");

        for (Product product : deleted) {
            System.out.println(product);
        }

        productBasket2.print();

        if (productBasket2.remove("Смартфон").isEmpty()) {
            System.out.println("Список пуст");
        }

        productBasket2.print();
    }
}



