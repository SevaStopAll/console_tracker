package ru.job4j.collection;

import java.util.Comparator;

public class SortDescByNameJob implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return right.getName().compareTo(left.getName());
    }
}
