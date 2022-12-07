package ru.job4j.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String name : shops) {
            if (name != null && name.length() > max) {
                    max = name.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}
