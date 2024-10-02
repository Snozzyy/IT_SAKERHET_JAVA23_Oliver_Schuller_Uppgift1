package com.example.Server.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;

public class Utils {

    // Hashing a password using SHA-256
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        String hashedPassword = DigestUtils.sha256Hex(password);
        System.out.println(hashedPassword);
        return hashedPassword;
    }
}
