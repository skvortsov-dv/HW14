package org.skypro.skyshop.product;

public class SearchEngine {
    private Searchable[] searchables;
    private int index;

    public SearchEngine(int n) {
        this.searchables = new Searchable[n];
        this.index = 0;
    }

    public void add(Searchable searchable) {
        searchables[index++] = searchable;
    }

    public Searchable[] search (String string) {
        Searchable[] answer = new Searchable[5];

        for (int i = 0, c = 0; i < index && c < 5; i++) {
            if (searchables[i].getStringRepresentation().contains(string)) {
                answer[c++] = searchables[i];
            }
        }

        return answer;
    }
}
