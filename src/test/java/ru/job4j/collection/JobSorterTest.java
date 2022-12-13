package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobSorterTest {

    @Test
    void whenCompareAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int rsl = cmpAscByName.compare(new Job("X task", 0),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isGreaterThan(0);
                }

    @Test
    void whenCompareDescByName() {
        Comparator<Job> cmpDescByName = new JobAscByName();
        int rsl = cmpDescByName.compare(new Job("X task", 1),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenCompareAscByPriority() {
        Comparator<Job> cmpAscByPriority = new JobAscByNameLength();
        int rsl = cmpAscByPriority.compare(new Job("X task", 0),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenCompareDescByPriority() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int rsl = cmpDescByPriority.compare(new Job("X task", 5),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorAscByLength() {
        Comparator<Job> cmpAscByLength = new JobAscByNameLength();
        int rsl = cmpAscByLength.compare(new Job("X task", 0),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isLessThan(1);
    }

    @Test
    void whenComparatorDescByLength() {
        Comparator<Job> cmpDescByLength = new JobDescByNameLength();
        int rsl = cmpDescByLength.compare(new Job("X task", 0),
                new Job("Make a cup of coffee", 9)
        );
        assertThat(rsl).isGreaterThan(-1);
    }

    @Test
    void whenComparatorByLengthAndPriority() {
        Comparator<Job> comb = new JobAscByNameLength().thenComparing(new JobAscByPriority());
        int rsl = comb.compare(new Job("Deploy app", 6), new Job("Install it", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorByPriorityAndLength() {
        Comparator<Job> comb = new JobDescByPriority().thenComparing(new JobDescByNameLength());
        int rsl = comb.compare(new Job("Call manager", 5), new Job("Have dinner", 5));
        assertThat(rsl).isLessThan(0);
    }
}
