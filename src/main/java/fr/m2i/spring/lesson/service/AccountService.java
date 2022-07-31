package fr.m2i.spring.lesson.service;

import fr.m2i.spring.lesson.dao.AccountDao;
import fr.m2i.spring.lesson.model.Account;
import static java.util.Comparator.comparing;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 * Cette classe est annoté  @Service, Spring va créer une instance de cette classe et va l'enregistrer dans
 * l'application context. Cette instance est appelé un bean.
 *
 * Ce service à une dépendance avec le dao. Si voulez que le conteneur injecte (set) cette dépendance, vous pouvez annoté le champs
 * avec @{@link Autowired} ou utiliser l'injection via le constructeur.
 *
 */
@Service
public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Optional<Account> findOldestClient() {
        return accountDao.getAllAccounts().stream().min(comparing(Account::getBirthday));
    }
}