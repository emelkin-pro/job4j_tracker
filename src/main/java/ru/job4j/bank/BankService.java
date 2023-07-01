package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Класс описывает логику работы с клиентами банка и банковскими считами.
 */

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя и добавляет его в список
     *
     * @param user клиент банка, который добавляется в список.
     */

    public void addUser(User user) {
        ArrayList<Account> accountsByUser = new ArrayList<>();
        users.putIfAbsent(user, accountsByUser);
    }

    /**
     * Удаляет клиента из списка. Клиента находят по паспортному номеру.
     *
     * @param passport это паспортный номер клиента,
     *                 по которому можно идентифицировать клиента.
     * @return true , если удалили клиента, иначе false.
     */

    public boolean deleteUser(String passport) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            users.remove(userByPassport);
            return true;
        }
        return false;
    }

    /**
     * Добавляет новый банковский счет к клиенту, по паспортному номеру.
     *
     * @param passport это паспортный номер клиента
     * @param account  это банковский счет, который будет привязан к клиенту
     */

    public void addAccount(String passport, Account account) {
        User userByPassport = findByPassport(passport);
        if (userByPassport != null) {
            List<Account> accountsList = users.get(userByPassport);
            if (!accountsList.contains(account)) {
                accountsList.add(account);
            }
        }

    }

    /**
     * Находит клиента по паспортному номеру
     *
     * @param passport паспортный номер клиента
     * @return возвращает клиента, если находит, иначе null
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Находит счет клиента, по реквизитам счета и паспортному номеру клиента
     *
     * @param passport  паспортный номер клиента
     * @param requisite реквизиты банковского счета
     * @return при нахождение возвращает банковский счет, иначе null
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (user != null) {
            return accountList
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
        }

    /**
     * Осуществляет перевод денег между счетами клиентов.
     *
     * @param srcPassport   номер паспорта переводящего деньги
     * @param srcRequisite  реквизиты банковского счета переводящего деньги
     * @param destPassport  номер паспорта получающего деньги
     * @param destRequisite реквизиты банковского счета получающего деньги
     * @param amount        сумма перевода
     * @return возвращает true, если перевод был успешен, иначе false
     */

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
