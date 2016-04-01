package com.khaannn;


import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by chatham_j on 4/1/2016.
 */
public class PasswordHasher {

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hash){
        if(!hash.startsWith("$2a$") || hash == null){
            throw new IllegalArgumentException("Not a BCrypt hash");
        }

        if(BCrypt.checkpw(password, hash)){
            return true;
        } else {
            return false;
        }
    }

}
