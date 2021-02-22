package ru.example.resttestapp.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ru.example.resttestapp.validators.CodeLength;

import javax.validation.constraints.NotEmpty;

/**
 * Класс для объекта 'Продукт'.
 *
 * @author r.kaminin
 */
@Data
@AllArgsConstructor
@Validated
public class Product {
    private static final int VALID_CODE_LENGTH = 13;
    private static final String VALID_CODE_MESSAGE = "The length must be equal " + VALID_CODE_LENGTH;

    @NotEmpty(message = "Please provide a 'name' field for Product!")
    private String name;

    @NotEmpty(message = "Please provide a 'code' field for Product!")
    @CodeLength(value = VALID_CODE_LENGTH, message = VALID_CODE_MESSAGE)
    private String code;
}
