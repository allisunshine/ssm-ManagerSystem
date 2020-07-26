package com.maxiaoyun.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "456";
        String pwd = encodePassword(password);
        //$2a$10$Md4xYkwVNNaKFXnVNBAeGeXH0cY40.ANa35wnSiqHZDKIuV6s3sLC
        //$2a$10$/GWMBmMWrw83JvUI3NJD..w58NLV3JCNVHBE6MZfcM.QOqtQzlicC
        System.out.println(pwd);
    }
}
