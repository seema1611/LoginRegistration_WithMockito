/*********************************************************************
 * @purpose : UserSerive class implement the business logic
 * @author  : Seema Rajpure
 * @Date    : 26/06/2020
 *********************************************************************/

package com.loginregistration.service.implementors;

import com.loginregistration.model.User;
import com.loginregistration.repository.IUserRepository;
import com.loginregistration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    /**+
     *
     * @purpose : Used to registerd user data
     * @param user
     * @return : Sava register data
     */

    @Override
    public User register(User user) {
        user.setRegisterDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    /**+
     *
     * @purpose : Used for check UserName and password mathches to the database entries or NOT
     * @param userName
     * @param password
     * @return : UseName and Password
     */
    @Override
    public User login(String userName, String password) {
        List<User> byUsername = userRepository.findAll();
        User user = byUsername.stream()
                .filter(userData -> userData.getUserName().equals(userName))
                .filter(userData -> userData.getPassword().equals(password))
                .findFirst()
                .get();
        return user;
    }

    /**+
     *
     * @purpose : Used for check UserName and password mathches to the database entries or NOT
     * @param emailId
     * @param password
     * @return : UserName and Password
     */
    @Override
    public User loginUserUsingEmailId(String emailId, String password) {
        return userRepository.findUserByEmailIdAndPassword(emailId,password);
    }
}