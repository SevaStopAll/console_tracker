package ru.job4j.ex;

public class Fact {
    public static int calc(int n) throws IllegalAccessException {
        if (n < 0) {
            throw new IllegalAccessException("N could not be less then 0.");
        }
        int rsl = 1;
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

}
