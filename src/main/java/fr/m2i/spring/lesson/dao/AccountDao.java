package fr.m2i.spring.lesson.dao;

import fr.m2i.spring.lesson.model.Account;
import java.util.List;


public interface AccountDao {
    List<Account> getAllAccounts();
}
