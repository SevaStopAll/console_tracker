package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] result = Arrays.copyOf(items, size);
        return result;
        }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int realSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[realSize] = items[i];
                realSize++;
            }
        }
        result = Arrays.copyOf(result, realSize);
        return result;
        }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = true;
        if (indexOf(id) == -1) {
            result = false;
            return result;
        } else {
            item.setId(id);
            items[indexOf(id)] = item;
        }
        return result;
    }

        public boolean delete(int id) {
            boolean result = true;
            if (indexOf(id)  == -1) {
                result = false;
                return result;
            }
            System.arraycopy(items, id + 1, items, id, size - id);
            items[size - 1] = null;
            size--;
            return result;
        }
    }
