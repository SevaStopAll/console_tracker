package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}
