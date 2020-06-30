/*********************************************************************
 * @purpose : User model used to convert data into object
 * @author  : Seema Rajpure
 * @Date    : 25/06/2020
 *********************************************************************/

package com.loginregistration.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int id;

    public String userName;

    public String password;

    @Column(unique = true)
    public String emailId;

    public String address;

    public LocalDateTime registerDate;

    public User() {
    }

    public User(String userName, String password, String emailId, String address) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}