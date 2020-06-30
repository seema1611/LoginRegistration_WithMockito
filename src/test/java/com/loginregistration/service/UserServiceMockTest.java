/*********************************************************************
 * @purpose : Test class for mock repository
 * @author  : Seema Rajpure
 * @Date    : 27/06/2020
 *********************************************************************/

package com.loginregistration.service;

import com.loginregistration.model.User;
import com.loginregistration.repository.IUserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith (SpringRunner.class)
@SpringBootTest
public class UserServiceMockTest {
    @Autowired
    IUserService userService;

    @MockBean
    IUserRepository userRepository;

    //TC-1 -> Test case for register user data
    @Test
    public void givenUser_WhenRegister_ShouldReturnUser() {
        User user = new User("Aju", "Aju@123", "ajusanas@gmail.com", "Mumbai");
        when(userRepository.save(user)).thenReturn(user);
        User registeredUser = userService.register(user);
        Assert.assertEquals(registeredUser, user);
    }

    //TC-2 -> Test case when passed null data
    @Test
    public void givenUser_WhenRegisterPassedNullData_ShouldReturnFalse() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);
        User registeredUser = userService.register(user);
        Assert.assertEquals(registeredUser, user);
    }

    //TC-3 -> Test case for login the user
    @Test
    public void givenUser_WhenLogin_ShouldReturnUser () {
        User user = new User("Aju", "Aju@123", "ajusanas@gmail.com", "Mumbai");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        User loginUser = userService.loginUserUsingEmailId("Aju@123","ajusanas@gmail.com");
        Assert.assertEquals(loginUser,user);
    }
}
