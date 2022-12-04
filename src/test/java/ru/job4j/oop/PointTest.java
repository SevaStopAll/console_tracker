package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    void whenA00B02Then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distance(b);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenA01B41Then4() {
        double expected = 4;
        Point a = new Point(0, 1);
        Point b = new Point(4, 1);
        double result = a.distance(b);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenA52B34Then2dot82() {
        double expected = 2.82;
        Point a = new Point(5, 2);
        Point b = new Point(3, 4);
        double result = a.distance(b);
        assertThat(result).isEqualTo(expected, offset(0.01));
    }

    @Test
    void whenA222B344Then3() {
        double expected = 3;
        Point a = new Point(2, 2, 2);
        Point b = new Point(3, 4, 4);
        double result = a.distance3d(b);
        assertThat(result).isEqualTo(expected, offset(0.01));
    }
}