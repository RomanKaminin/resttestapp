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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createOrder() throws Exception {
        String exampleOrderJson = "{\"seller\":\"999999999\",\"customer\":\"999999999\",\"products\":[{\"name\":\"milk\",\"code\":\"1111111111111\"}]}";
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON).content(exampleOrderJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void customerLengthCode() throws Exception {
        String expectedJson = "[{\"field\":\"customer\",\"value\":\"11\",\"message\":\"The length must be equal 9\"}]";
        String requestJson = "{\"seller\":\"111111111\",\"customer\":\"11\",\"products\":[{\"name\":\"milk\",\"code\":\"1111111111111\"}]}";
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void sellerLengthCode() throws Exception {
        String expectedJson = "[{\"field\":\"seller\",\"value\":\"222222222222\",\"message\":\"The length must be equal 9\"}]";
        String requestJson = "{\"seller\":\"222222222222\",\"customer\":\"111111111\",\"products\":[{\"name\":\"milk\",\"code\":\"1111111111111\"}]}";
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void productLengthCode() throws Exception {
        String expectedJson = "[{\"field\":\"products[0].code\",\"value\":\"36563521111437590\",\"message\":\"The length must be equal 13\"}]";
        String requestJson = "{\"seller\":\"111111111\",\"customer\":\"111111111\",\"products\":[{\"name\":\"milk\",\"code\":\"36563521111437590\"}]}";
        RequestBuilder requestBuilder = post("/api/order")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedJson));
    }

}
