/*********************************************************************
 * @purpose : Controller used for handling the request and resposnse
 * @author  : Seema Rajpure
 * @Date    : 25/06/2020
 *********************************************************************/

package com.loginregistration.controller;

import com.loginregistration.model.User;
import com.loginregistration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    /**+
     *
     * @purpose  : Used for handling the register request and response
     * @param user
     * @return : user
     */

    @GetMapping("/register")
    public User register (@RequestBody User user) {
        return userService.register(user);
    }

    /**+
     *
     * @purpose  : Used for handling the login request and response
     * @param user
     * @return : userName and password for login
     */

    @PostMapping ("/login")
    public User login (@RequestParam (value = "userName") String userName,
                       @RequestParam (value = "password") String password) {
        return userService.login(userName, password);
    }
}
