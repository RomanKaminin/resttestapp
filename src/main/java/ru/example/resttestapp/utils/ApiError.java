package ru.example.resttestapp.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    @JsonIgnore
    private int code;
    private String field;
    private String value;
    private String message;

    public ApiError(String message) {
        this.message = message;
    }

    public ApiError(String field, String value, String message) {
        this.field = field.replace("createOrder.order.", "");
        this.value = value;
        this.message = message;
    }
}
