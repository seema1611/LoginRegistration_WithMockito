/*********************************************************************
 * @purpose : Test the controller class
 * @author  : Seema Rajpure
 * @Date    : 27/06/2020
 *********************************************************************/
package com.loginregistration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /**+
     *
     * @param object
     * @return : Write data in JSON
     * @throws JsonProcessingException
     */

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    //TC-1 -> Correct and not null Register data passed here
    @Test
    public void givenRegister_WhenUserBodyPassed_ShouldReturnUser() throws Exception {
        User user = new User("Aju", "Aju@123", "ajusanas@gmail.com", "Mumbai");
        String userJson = this.mapToJson(user);
        given(userService.register(any(User.class))).willReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .accept(MediaType.APPLICATION_JSON).content(userJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputInJson = response.getContentAsString();
        Assert.assertEquals(outputInJson, userJson);
    }

    //TC-2 -> Null data is passed here
    @Test
    public void givenRegister_WhenUserBodyPassedNull_ShouldReturnFalse() throws Exception {
        User user = new User();
        String userJson = this.mapToJson(user);
        given(userService.register(any(User.class))).willReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .accept(MediaType.APPLICATION_JSON).content(userJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputInJson = response.getContentAsString();
        Assert.assertEquals(outputInJson, userJson);
    }
}