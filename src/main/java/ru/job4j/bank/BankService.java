package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        if (users.containsKey(findByPassport(passport))) {
            users.remove(findByPassport(passport));
            return true;
        }
        return false;

    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport)) && !getAccounts(findByPassport(passport)).contains(account)) {
            getAccounts((findByPassport(passport))).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account account : getAccounts(findByPassport(passport))) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(srcPassport, srcRequisite) == null
                || findByRequisite(destPassport, destRequisite) == null
                || findByRequisite(srcPassport, srcRequisite).getBalance() < amount) {
            return rsl;
        }
        findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
        rsl = true;
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
