package ru.example.resttestapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeLengthValidator implements ConstraintValidator<CodeLength, String> {

    private Integer maxLength;

    @Override
    public void initialize(CodeLength codeLength) {
        maxLength = codeLength.value();
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {

        return field != null && field.length() == this.maxLength;
    }
}
