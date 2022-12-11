package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    void when3ItemsSorted() {
        List<Item> result = new ArrayList<>();
        result.add(new Item("Report to IT support", 12));
        result.add(new Item("Call manager", 21));
        result.add(new Item("Go home soon", 1));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Report to IT support", 12));
        expected.add(new Item("Go home soon", 1));
        expected.add(new Item("Call manager", 21));
        result.sort(new ItemDescByName());
        assertThat(result).isEqualTo(expected);
    }

}