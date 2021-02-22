package ru.example.resttestapp.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private String exampleOrderJson = "{\"seller\":\"999999999\",\"customer\":\"999999999\",\"products\":[{\"name\":\"milk\",\"code\":\"1111111111111\"}]}";
    private String errorOrderJson = "{\"seller\":\"111111111\",\"customer\":\"11\",\"products\":[{\"name\":\"milk\",\"code\":\"1111111111111\"}]}";

    @Test
    public void createOrder() throws Exception {
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON).content(exampleOrderJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void orderWithNotCorrectFields() throws Exception {
//        String expectedJson = "[{\"field\":\"customer\",\"value\":\"11\",\"products\":\"The length must be equal 9\"}]";
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON)
                .content(errorOrderJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

}
