package com.martinkondor.textshare;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BCryptPasswordEncoder {
    private final int length;
    private final String staticSaltLeft = "QUYmhP9CenH";
    private final String staticSaltRight = "AvarjGDyK5c";

    public BCryptPasswordEncoder(int length) {
        this.length = length;
    }

    public String encode(String rawPassword) throws RuntimeException {
        String toEncrypt = this.staticSaltLeft + rawPassword + this.staticSaltRight;
        return this.getMd5Hash(toEncrypt);
    }

    public boolean matches(String rawPassword, String encryptedPassword) throws RuntimeException {
        String encryptedRawPassword = this.encode(rawPassword);
        return encryptedPassword.equals(encryptedRawPassword);
    }

    private String getMd5Hash(String input) throws RuntimeException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(this.length);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
