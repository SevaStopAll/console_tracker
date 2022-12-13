package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    public static int findNumber(String string) {
     String[] data = string.split("\\.");
     return Integer.parseInt(data[0]);
    }

    @Override
    public int compare(String left, String right) {
        return Integer.compare(findNumber(left), findNumber(right));
    }
}