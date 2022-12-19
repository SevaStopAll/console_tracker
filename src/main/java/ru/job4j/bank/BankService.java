package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Класс позволяет проводить банковские переводы между счетами, рабоатать с базой клиентов и счетов,
 * добавлять и удалять клиентов и счета */
public class BankService {

    /**
     * Клиенты и счета хранятся в коллекции HashMap, позволяющей записать на одного
     * клиента несколько счетов, открывая их по необходимости.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и добавляет его в базу с клиентами, если
     * такого клиента нет в базе.
     * @param user - клиент, которого добавляют в базу.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод приимает на вход номер паспорта, по которому производится поиск. Если
     * клиент найден - происходит его удаление.
     * @param passport - номер паспорта клиента.
     * @return - возвращает true при удалении или false, если клиент
     * с таким паспортом не найден
     */
    public boolean deleteUser(String passport) {
        return  users.remove(new User(passport, "")) != null;

    }

    /**
     * Метод принимает на вход номер паспорта клиента, которому нужно добавить счет,
     * а также новый счет, который необходимо привязать к клиенту.
     * @param passport - номер паспорта клиента, к которому привязывается счет
     * @param account - счет, который будет добавлен клиенту.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            getAccounts(user).add(account);
        }
    }

    /**
     * Метод принимает на вход номер паспорта, по которому производится поиск клиента.
     * @param passport - номер паспорта, по которому будет проводиться поиск.
     * @return - возвращает клиента, если поиск успешен, либо null, если
     * ничего не найдено.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
            }

    /**
     * Метод принимает на вход номер паспорта клиента и реквизиты счета, по которым
     * будет проводиться поиск.
     * @param passport - номер паспорта, по нему будет поиск клиента
     * @param requisite - реквизиты счета, по ним будет проводиться поиск счета
     * @return возвращает счет, если клиент и счет найдены, возвращает null, если
     * клиент или счет не найдены.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

    /**
     * Метод принимает на вход номер паспорта и номер счета клиента, который переводит
     * деньги, а также номер паспорта и номер счета, клиента, которому переводят деньги,
     * и сумму перевода.
     *
     * @param srcPassport - номер паспорта отправителя
     * @param srcRequisite - реквизиты счета отправителя
     * @param destPassport - номер паспорта получателя
     * @param destRequisite - реквизиты счета получателя
     * @param amount - сумма перевода
     * @return - если успешно найдены отправитель, получатель и их счета, а также у
     * отправителя достаточно средств - возвращает true. Иначе возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null || src.getBalance() < amount) {
            return false;
        }
        dest.setBalance(dest.getBalance() + amount);
        src.setBalance(src.getBalance() - amount);
        return true;
    }

    /**
     * Метод принимает на вход клиента, счета которого надо найти
     * @param user - клиент, счета которого надо найти
     * @return - возвращает список счетов клиента в коллекции List.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
