/*********************************************************************
 * @purpose : Repository is used to performed CRUD operation
 * @author  : Seema Rajpure
 * @Date    : 26/06/2020
 *********************************************************************/

package com.loginregistration.repository;

import com.loginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.emailId=?1 and u.password=?2")
    User findUserByEmailIdAndPassword(String emailId, String password);
}
