package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return Integer.compare(job1.getPriority(), job2.getPriority());
    }
}
