package bg.softuni.json_intro.utils;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {
    
    private final Validator validator;


    public ValidatorUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> Boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
