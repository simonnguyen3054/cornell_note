package com.cornell.note.cornellnote.shared.dto;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component //Spring container will register this class as a Spring Bean
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    //This method generates a random string of characters for user_id
    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for(int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
