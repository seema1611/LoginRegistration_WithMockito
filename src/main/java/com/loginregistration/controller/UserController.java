/*********************************************************************
 * @purpose : Controller used for handling the request and resposnse
 * @author  : Seema Rajpure
 * @Date    : 25/06/2020
 *********************************************************************/

package com.loginregistration.controller;

import com.loginregistration.model.ResponseDto;
import com.loginregistration.model.User;
import com.loginregistration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**+
     *
     * @purpose  : Used for handling the register request and response
     * @param user
     * @return : user
     */
    @PostMapping("/register")
    public User register (@RequestBody User user) {
        return userService.register(user);
    }

    /**+
     *
     * @param password
     * @param emailId
     * @return :  UserName and Password
     */
    @PostMapping ("/loginwithemail")
    public ResponseEntity<ResponseDto> loginUser(@RequestParam (value = "password") String password,
                                                 @RequestParam (value = "emailId") String emailId) {
        User user = userService.loginUserUsingEmailId(password, emailId);
        ResponseDto responseDto = new ResponseDto(user, "Login Successful", 200);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
