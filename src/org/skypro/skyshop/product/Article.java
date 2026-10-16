package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//    @Override
//    public int compareTo(Object o) {
//        Article article = (Article) o;
//
//        int lengthCompare = Integer.compare(this.name.length(), article.name.length());
//
//        if (lengthCompare == 0){
//            return this.name.compareTo(article.name);
//        }
//
//        return lengthCompare;
//    }
}
