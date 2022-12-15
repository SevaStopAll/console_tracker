package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка, его номер паспорта и имя.
 */
public class User {
    /**
     * Номер паспорта клиента
     */
    private String passport;
    /**
     * Имя клиента
     */
    private String username;

    /**
     * Создание нового клиента
     * @param passport - номер паспорта
     * @param username - имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
