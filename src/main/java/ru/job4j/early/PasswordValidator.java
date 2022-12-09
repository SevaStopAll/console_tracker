package ru.job4j.early;

import java.util.Locale;

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
        return password;
    }
}
        /*for (int index = 0; index < password.length(); index++)  {
                if (Character.isLowerCase(password.charAt(index))) {
                    break;
                }
                throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        for (int index = 0; index < password.length(); index++)  {
            if (Character.isDigit(password.charAt(index))) {
                break;
            }
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        for (int index = 0; index < password.length(); index++)  {
            if (Character.isDigit(password.charAt(index))) {
                break;
            }
            throw new IllegalArgumentException("Password should contain at least one figure");
        }*/
