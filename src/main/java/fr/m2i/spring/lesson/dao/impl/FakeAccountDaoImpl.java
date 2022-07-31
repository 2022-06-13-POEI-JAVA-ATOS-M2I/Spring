package fr.m2i.spring.lesson.dao.impl;
import fr.m2i.spring.lesson.dao.AccountDao;
import fr.m2i.spring.lesson.model.Account;
import fr.m2i.spring.lesson.model.Gender;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Cette classe est annoté avec @{@link Component}, le conteneur Spring va créer une instance de la classe {@link FakeAccountDaoImpl}
 * et va l'enregistrer dans le contexte.
 */
@Component
public class FakeAccountDaoImpl implements AccountDao {

    @Override
    public List<Account> getAllAccounts() {
        //return TestDataGenerator.getAccountList(10);
        List<Account> accounts = new ArrayList<>();
        
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        accounts.add(new Account("Mark", "Dean", "mark.dean@mail.com", LocalDate.now(), Gender.MALE, LocalDateTime.now()));
        
        return accounts;
    }
}