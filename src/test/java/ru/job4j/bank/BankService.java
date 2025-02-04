package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User findByPass = findByPassport(passport);
        if (findByPass != null
                && !users.get(findByPass).contains(account)) {
            users.get(findByPass).add(account);
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
        User findByPass = findByPassport(passport);
        if (findByPass != null) {
            for (Account value : users.get(findByPass)) {
                if (requisite.equals(value.getRequisite())) {
                    return value;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account dest = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && dest != null && source.getBalance() >= amount) {
            findByRequisite(sourcePassport, sourceRequisite).setBalance(source.getBalance() - amount);
            findByRequisite(destinationPassport, destinationRequisite).setBalance(dest.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}