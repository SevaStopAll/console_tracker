package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                return index;
            }
        }
        throw new ElementNotFoundException("Element wasn't found");
    }

    public static void main(String[] args) {
        String[] value = {"Not a Key", "Not a key", "Not a key"};
        String key = "Key";
        try {
            System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}