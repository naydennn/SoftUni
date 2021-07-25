package bg.softuni.xml_intro.utils.impl;

import bg.softuni.xml_intro.utils.ValidationUtil;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidationUtilImpl() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> Boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
