package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;

@Component
public class ValidationUtilImpl implements ValidationUtil {


    @Override
    public <E> boolean isValid(E entity) {
        return Validation.buildDefaultValidatorFactory()
                .getValidator().validate(entity).isEmpty();
    }
}
