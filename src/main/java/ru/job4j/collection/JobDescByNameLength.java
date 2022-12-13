package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameLength implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return Integer.compare(job2.getName().length(), job1.getName().length());
    }
}
