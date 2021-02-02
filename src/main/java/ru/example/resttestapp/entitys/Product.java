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
    private static final int PRODUCT_CODE_LENGTH = 13;

    @NotEmpty(message = "Please provide a 'name' field for Product!")
    private String name;

    @NotEmpty(message = "Please provide a 'code' field for Product!")
    @CodeLength(value = PRODUCT_CODE_LENGTH, message = "The length must be equal 13")
    private String code;
}
