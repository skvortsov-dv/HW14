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

    public Searchable getSearchTerm(String substring) throws BestResultNotFound {
        int bestCount = 0;
        Searchable bestSearchable = null;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

            String text = searchable.getStringRepresentation();

            int count = 0;

            int index = 0;
            int substringIndex = text.indexOf(substring, index);

            while (substringIndex != -1) {
                count++;
                index = substringIndex + substring.length();
                substringIndex = text.indexOf(substring, index);
            }

            if (count > bestCount) {
                bestCount = count;
                bestSearchable = searchable;
            }
        }

        if (bestSearchable == null) {
            throw new BestResultNotFound("Подстрока \"" + substring + "\" не найдена");
        }

        return bestSearchable;
    }
}
