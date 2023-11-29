package com.martinkondor.textshare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BCryptPasswordEncoderTest {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    @Test
    void encode() {
        String passwordRaw = "Password123";
        String passwordEnc = "54d75a7618c7203b5be7db40e749f7c1";
        assert passwordEncoder.encode(passwordRaw).equals(passwordEnc) == true;
    }

    @Test
    void matches() {
        String passwordGood = "Password123";
        String passwordEnc = "54d75a7618c7203b5be7db40e749f7c1";
        String passwordBad = "password";
        assert passwordEncoder.matches(passwordGood, passwordEnc) == true;
        assert passwordEncoder.matches(passwordBad, passwordEnc) == false;
    }
}
