package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accountsByUser = new ArrayList<>();
        users.putIfAbsent(user, accountsByUser);
    }

    public boolean deleteUser(String passport) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            users.remove(userByPassport);
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            List<Account> accountsList = users.get(userByPassport);
            if (!accountsList.contains(account)) {
                accountsList.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (user != null) {
            for (int i = 0; i < accountList.size(); i++) {
                Account account = accountList.get(i);
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
