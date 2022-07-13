package com.bookout;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

    public static String hash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(password.getBytes());
            byte[] result = digest.digest();

            StringBuilder builder = new StringBuilder();

            for (byte b: result) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
