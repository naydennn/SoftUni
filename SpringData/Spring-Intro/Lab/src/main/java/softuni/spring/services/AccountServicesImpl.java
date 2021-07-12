package softuni.spring.services;

import org.springframework.stereotype.Service;
import softuni.spring.models.Account;
import softuni.spring.repositories.AccountRepository;

import java.math.BigDecimal;

@Service
public class AccountServicesImpl implements AccountServices {

    private final AccountRepository accountRepository;

    public AccountServicesImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account account = getAccount(id);

        if (account.getBalance().compareTo(money) < 0) {
            System.out.println("Not enough money");
        }

        account.setBalance(account.getBalance().subtract(money));
        this.accountRepository.save(account);
    }

    private Account getAccount(Long id) {
        return this.accountRepository.findAccountById(id);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = getAccount(id);

        account.setBalance(account.getBalance().add(money));

        accountRepository.save(account);
    }
}
