package ru.example.resttestapp.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.resttestapp.entitys.Order;

import javax.validation.Valid;


/**
 * Котроллер для обработки заказов.
 *
 * @author r.kaminin
 */
@RestController
@Validated
@RequestMapping("/api")
public class OrderController {

    @PostMapping(value = "/order", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity createOrder(@Valid @RequestBody Order order, BindingResult result) {
        if (order == null)
            return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(order);
    }


}
