package com.example.Server.security;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;

public class Hash {

    // Hashing a password using SHA-256
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Uses DigestUtils-library to easily hash a password with SHA-256
        return DigestUtils.sha256Hex(password);
    }
}
