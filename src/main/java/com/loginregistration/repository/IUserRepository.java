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

    @Query("select u from User u where u.password=?1 and u.emailId=?2")
    User findUserByEmailIdAndPassword(String password, String emailId);
}