package bg.softuni.spring_mapper_ex.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> Boolean isValid(E entity);

    <E> Set<ConstraintViolation<E>> violation(E entity);
}
