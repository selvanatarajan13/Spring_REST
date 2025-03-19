package com.example.RESTAPI.__Restapi_UserSignUp;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new Random();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserId(int length) {
        return generatedRandomString(length);
    }

    private String generatedRandomString(int length) {

        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            randomString.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return String.valueOf(randomString);
    }
}
