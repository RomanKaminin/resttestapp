package ru.example.resttestapp.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ru.example.resttestapp.validators.CodeLength;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Класс для объекта 'Заказ'.
 *
 * @author r.kaminin
 */
@Data
@AllArgsConstructor
@Validated
public class Order {
    private static final int VALID_CODE_LENGTH = 9;
    private static final String VALID_CODE_MESSAGE = "The length must be equal " + VALID_CODE_LENGTH;

    @NotEmpty(message = "Please provide a 'seller' field for Order!")
    @CodeLength(value = VALID_CODE_LENGTH, message = VALID_CODE_MESSAGE)
    private String seller;

    @NotEmpty(message = "Please provide a 'customer' field for Order!")
    @CodeLength(value = VALID_CODE_LENGTH, message = VALID_CODE_MESSAGE)
    private String customer;

    @NotEmpty(message = "Please provide a 'products' field for Order!")
    private List<@Valid Product> products;

}
