package softuni.spring.services;

import java.math.BigDecimal;

public interface AccountServices {
    void withdrawMoney(BigDecimal money, Long id);
    void transferMoney(BigDecimal money, Long id);
}
