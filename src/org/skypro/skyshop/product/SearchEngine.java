package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;
//    private int index;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
//        this.index = 0;
    }

    public void add(Searchable searchable) {
//        searchables[index++] = searchable;
        searchables.add(searchable);
    }

    public Map<String, Searchable> search (String string) {
//        Searchable[] answer = new Searchable[5];
//        List<Searchable> answer = new ArrayList<>();
        Map<String, Searchable> answer = new TreeMap<>();

//        for (int i = 0, c = 0; i < index && c < 5; i++) {
        for (Searchable searchable : searchables) {
            if (searchable.getStringRepresentation().contains(string)) {
//                answer[c++] = searchables[i];
//                if (!answer.containsKey(searchable.getName())) {
//                    answer.put(searchable.getName(), new ArrayList<>());
//                }

//                answer.get(searchable.getName()).add(searchable);

                answer.put(searchable.getName(), searchable);
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
