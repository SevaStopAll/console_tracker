package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if ()
            if (value[index].equals(key)) {
                rsl = index;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"Key", "Not key", "Not key"}
        FindEl.indexOf(value,"Key");
    }
}
