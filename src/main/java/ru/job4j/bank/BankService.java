package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса c помощью коллекций
 * @author Dmitriy Trotsenko
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию
     * @param user пользователь, который принимается методом на вход
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта пользователя, используя метод поиска
     * пользователя по паспорту и удаляет пользователя из системы
     * @param passport номер паспорта для поиска пользователя в коллекции
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и банковский счет,
     * использует метод поиска пользователя по паспорту, если он находит пользователя
     * и при проверке у пользователя не выявляется такого банковского счета, то метод
     * добавляет пользователю новый банковский счет
     * @param passport номер паспорта для поиска пользователя в коллекции
     * @param account банковский счет для добавления пользователю
     */
    public void addAccount(String passport, Account account) {
        User findByPass = findByPassport(passport);
        if (findByPass != null
                && !users.get(findByPass).contains(account)) {
            users.get(findByPass).add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру его паспорта
     * @param passport номер паспорта пользователя, по которому осуществлчяется поиск
     * @return возвращает пользователя по номеру паспорта или null, если паспорт не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и номер банковского счета,
     * использует метод поиска пользователя по паспорту, если он находит пользователя
     * и у пользователя имеется такой номер банковского счета, то метод возвращает банковский счет
     * @param passport номер паспорта для поиска пользователя в коллекции
     * @param requisite номер банковского счета для поиска по нему
     * @return возвращает банковский счет или null, если счет не найден
     */
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

    /**
     * Метод используется для перечисления денег с одного счета на другой
     * @param sourcePassport номер паспорта пользователя, переводящего деньги
     * @param sourceRequisite номер счета пользователя, переводящего деньги
     * @param destinationPassport номер паспорта пользователя, принимающего деньги
     * @param destinationRequisite номер счета пользователя, принимающего деньги
     * @param amount сумма перевода
     * @return возвращает true, если номера счетов переводящего и принимающего деньги существуют
     * и сумма перевода не превышает суммы на счете списания, иначе возвращает false
     */
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

    /**
     * Метод возвращает значения, ассоциированные с пользователем
     * @param user пользователь, который принимается методом на вход
     * @return возвращает значение пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}