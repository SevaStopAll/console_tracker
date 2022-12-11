package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {

    @Override
    public int compare(Item left, Item right) {
        return right.getName().compareTo(left.getName());
    }
}
