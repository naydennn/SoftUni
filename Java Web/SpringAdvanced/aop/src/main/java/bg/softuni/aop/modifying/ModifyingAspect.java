package bg.softuni.aop.modifying;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingAspect {

    @Pointcut("execution(* bg.softuni.aop.Student.concat(..))")
    public void concat() {
    }

    @Around("concat() && args(a, b)")
    public Object modify(ProceedingJoinPoint point, String a, String b) throws Throwable {
        Object returnValue = point.proceed(new Object[]{
                "[" + a + "]",
                "[" + b + "]",
        });

        return "(" + returnValue + ")";
    }
}
