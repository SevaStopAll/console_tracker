package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {

    @Override
    public int compare(Item left, Item right) {
        return left.getName().compareTo(right.getName());
    }
}
