package ru.example.resttestapp.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CodeLengthValidator.class)
@Documented
public @interface CodeLength {

    int value()  default 9;

//    String message() default  "{CodeLength.invalid}";
    String message() default  "{CodeLength.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
