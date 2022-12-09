package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        String[] denied = {"qwerty", "12345", "password", "user", "admin"};
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (String option : denied) {
            if (password.toLowerCase().contains(option)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return checkChars(password);
    }

    public static String checkChars(String password) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        char[] symbols = password.toCharArray();
        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                digits++;
            }
            if (Character.isLowerCase(symbol)) {
                lower++;
            }
            if (Character.isUpperCase(symbol)) {
                upper++;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                special++;
            }
            if (upper > 0 && lower > 0 && digits > 0 && special > 0) {
                break;
            }
        }
        if (upper == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (lower == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (digits == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (special == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}
