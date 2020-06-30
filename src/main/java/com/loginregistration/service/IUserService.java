/*********************************************************************
 * @purpose : IUserService interface is used for managed service operation
 * @author  : Seema Rajpure
 * @Date    : 26/06/2020
 *********************************************************************/

package com.loginregistration.service;

import com.loginregistration.model.User;

public interface IUserService {

    /**+
     *
     * @purpose : To managed register method in service class
     * @param user
     */
    User register(User user);

    /**+
     *
     * @purpose : To managed login method in service class
     * @param userName
     * @param password
     */
    User login(String userName, String password);

    /**+
     *
     * @purpose : To login the user
     * @param emailId
     * @param password
     */
    User loginUserUsingEmailId(String emailId, String password);
}
