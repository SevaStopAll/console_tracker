package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByNameLength implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return Integer.compare(job1.getName().length(), job2.getName().length());
    }
}
