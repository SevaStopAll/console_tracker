package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("12345") || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("user") || password.toLowerCase().contains("admin")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        int upper = 0;
        int lower = 0;
        int digits = 0;
        int special = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digits++;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                lower++;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                upper++;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                special++;
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
