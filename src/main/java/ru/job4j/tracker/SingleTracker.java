package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {

    private MemTracker memTracker = new MemTracker();

    private static SingleTracker instance = null;

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    private SingleTracker() {
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}