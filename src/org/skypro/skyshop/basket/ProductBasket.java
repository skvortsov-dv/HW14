package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;
//    private int index;

    public ProductBasket() {
        this.products = new HashMap<>();

//        this.index = 0;
    }

    public void add(Product product) {
//        if (!products.containsKey(product.getName())){
//            products.put(product.getName(), new ArrayList<>());
//        }
//
//        products.get(product.getName()).add(product);

        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int sum() {
//        int sum = 0;
//
////        for (int i = 0; i < index; i++) {
////            sum += products[i].getPrice();
////        }
//        for (List<Product> list : products.values()) {
//            for (Product product : list) {
//                sum += product.getPrice();
//            }
//        }
//
//        return sum;

        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
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

//            for (List<Product> list : products.values()) {
//                for (Product product : list) {
//                    if (product.isSpecial()) {
//                        special += 1;
//                    }
//                    System.out.println(product);
//                }
//            }

//            for (Product product : products) {
//                if (product.isSpecial()) {
//                    special += 1;
//                }
//                System.out.println(product);
//            }

            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);

            System.out.println("Итого: " + sum());
            System.out.println("Специальных товаров: " + products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count());
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

//        for (List<Product> list : products.values()) {
//            for (Product product : list) {
//                if (product.getName().equals(name)) {
//                    return true;
//                }
//            }
//        }

        return products.values().stream().flatMap(Collection::stream).anyMatch(product -> product.getName().equals(name));
//        for (Product product: products) {
//            if (product.getName().equals(name)) {
//                return true;
//            }
//        }

//        return false;
    }

    public void clear() {
        products.clear();
    }

    public List<Product> remove(String name) {
//        List <Product> deleted = new ArrayList<>();

        List <Product> deleted = products.remove(name);

        if (deleted == null) {
            return new ArrayList<>();
        } else {
            return deleted;
        }

//        Iterator<Product> iterator = products.iterator();
//
//        while (iterator.hasNext()){
//            Product item = iterator.next();
//
//            if (item.getName().equals(name)) {
//                deleted.add(item);
//                iterator.remove();
//            }
//        }

//        return deleted;
    }
}
