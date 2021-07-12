package softuni.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountById(Long id);
}
