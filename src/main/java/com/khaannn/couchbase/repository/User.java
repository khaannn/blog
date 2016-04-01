package com.khaannn.couchbase.repository;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.khaannn.PasswordHasher;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;


/**
 * Created by khaannn on 3/31/2016.
 */
@Document
public class User {
     @Id
    private String userName;

    @Field
    private Date registrationDate;

    @Field
    private int securityLevel;

    @Field
    private String passwordHash;


    public User(){
        this.initialize();
    }

    public User(String userName, int securityLevel, String passwordHash){
        this.userName = userName;
        this.securityLevel = securityLevel;
        this.passwordHash = PasswordHasher.hashPassword(passwordHash);
        this.initialize();
    }

    private void initialize(){
        this.registrationDate = new Date();
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
