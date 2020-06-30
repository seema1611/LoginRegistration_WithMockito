/*********************************************************************
 * @purpose : IUserService interface is used for managed service operation
 * @author  : Seema Rajpure
 * @Date    : 26/06/2020
 *********************************************************************/

package com.loginregistration.service;

import com.loginregistration.model.User;

public interface IUserService {

    User register(User user);

    User login(String userName, String password);

    User loginUserUsingEmailId(String password,String emailId);
}
