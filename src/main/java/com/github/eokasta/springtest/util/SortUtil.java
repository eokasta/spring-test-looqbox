package com.github.eokasta.springtest.util;

import com.github.eokasta.springtest.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

    /**
     * Sort a list with Bubble Sort.
     * This algorithm has a worst-case time complexity of O(n2)
     *
     * @param content the list to sort.
     * @param type {@link Type} of sort
     * @return sorted list.
     */
    public static List<Pokemon> sort(List<Pokemon> content, Type type) {
        final int size = content.size();
        final List<Pokemon> sortedList = new ArrayList<>(content);

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                final Pokemon firstElement = sortedList.get(i);
                final Pokemon lastElement = sortedList.get(j);

                if (type == Type.LENGTH && firstElement.getName().length() > lastElement.getName().length()) {
                    invertPositions(sortedList, i, j);
                    continue;
                }

                if (type == Type.ALPHABETICAL && firstElement.getName().compareTo(lastElement.getName()) > 0) {
                    invertPositions(sortedList, i, j);
                }
            }
        }

        return sortedList;
    }

    /**
     * Invert positions of two elements of a list.
     *
     * @param content the list.
     * @param indexOne index of first element.
     * @param indexTwo index of last element.
     */
    private static void invertPositions(List<Pokemon> content, int indexOne, int indexTwo) {
        final Pokemon firstElement = content.get(indexOne);
        final Pokemon lastElement = content.get(indexTwo);

        content.set(indexOne, lastElement);
        content.set(indexTwo, firstElement);
    }

    public enum Type {

        ALPHABETICAL,
        LENGTH

    }

}
