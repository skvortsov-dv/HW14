package org.skypro.skyshop.product;

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
}
