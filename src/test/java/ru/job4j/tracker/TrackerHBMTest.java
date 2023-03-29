package ru.job4j.tracker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHBMTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName().equals(item.getName()));
        }
    }

    @Test
    public void whenFindByNameTwoElements() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = tracker.add(new Item("item"));
            Item item2 = tracker.add(new Item("item"));
            assertThat(tracker.findByName("item")).containsAll(List.of(item1, item2));
        }
    }

    @Test
    public void whenDeleteIsSuccessful() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.delete(item.getId())).isTrue();
        }
    }

    @Test
    public void whenReplaceIsTrue() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = tracker.add(new Item("item1"));
            tracker.replace(item1.getId(), new Item("test2"));
            assertThat("test2").isEqualTo(tracker.findById(item1.getId()).getName());
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = tracker.add(new Item("item1"));
            Item item2 = tracker.add(new Item("item2"));
            Item item3 = tracker.add(new Item("item3"));
            assertThat(tracker.findAll()).containsAll(List.of(item1, item2, item3));
        }
    }
}
