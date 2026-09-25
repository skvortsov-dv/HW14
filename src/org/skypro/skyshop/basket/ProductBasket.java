package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products;
//    private int index;

    public ProductBasket() {
        this.products = new ArrayList<>();
//        this.index = 0;
    }

    public void add(Product product) {
        products.add(product);
    }

    public int sum() {
        int sum = 0;

//        for (int i = 0; i < index; i++) {
//            sum += products[i].getPrice();
//        }
        for (Product product : products) {
            sum += product.getPrice();
        }

        return sum;
    }

    public void print() {
        if (!products.isEmpty()) {
            int special = 0;

//            for (int i = 0; i < index; i++) {
//                if (products [i].isSpecial()) {
//                    special += 1;
//                }
//                System.out.println(products[i]);
//            }
            for (Product product : products) {
                if (product.isSpecial()) {
                    special += 1;
                }
                System.out.println(product);
            }

            System.out.println("Итого: " + sum());
            System.out.println("Специальных товаров: " + special);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean contains(String name) {
//        for (int i = 0; i < index; i++) {
//            if (products[i].getName().equals(name)) {
//                return true;
//            }
//        }
        for (Product product: products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        products.clear();
    }

    public List<Product> remove(String name) {
        List <Product> deleted = new ArrayList<>();

        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()){
            Product item = iterator.next();

            if (item.getName().equals(name)) {
                deleted.add(item);
                iterator.remove();
            }
        }

        return deleted;
    }
}
