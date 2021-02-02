package ru.example.resttestapp.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Обработчик исключений api.
 */
@RestControllerAdvice
public class ExceptionTranslator {

    /**
     * Обработчик исключений для ошибок проверки, вызванных параметрами метода
     * @RequesParam, @PathVariable, @RequestHeader,
     * аннотированными ограничениями javax.validation.
     */
    @ExceptionHandler
    protected ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {

        final List<ApiError> apiErrors = new ArrayList<>();

        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            final String value = (violation.getInvalidValue() == null ? null : violation.getInvalidValue().toString());
            apiErrors.add(new  ApiError(violation.getPropertyPath().toString(), value, violation.getMessage()));
        }

        return ResponseEntity.badRequest().body(apiErrors);
    }
}
