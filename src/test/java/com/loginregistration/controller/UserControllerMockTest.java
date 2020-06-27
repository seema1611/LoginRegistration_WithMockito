package com.loginregistration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loginregistration.controller.UserController;
import com.loginregistration.model.User;
import com.loginregistration.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest (UserController.class)
public class UserControllerMockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IUserService userService;


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Test
    public void givenRegisterApi_WhenUserBodySent_ShouldReturnUser() throws Exception {
        User user = new User("Aju", "Aju@123", "ajusanas@gmail.com", "Mumbai");
        String userJson = this.mapToJson(user);
        given(userService.register(any(User.class))).willReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/register")
                .accept(MediaType.APPLICATION_JSON).content(userJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder)
                .andReturn();
        System.out.println(mvcResult);
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputInJson = response.getContentAsString();
        Assert.assertEquals(outputInJson, userJson);
    }
}