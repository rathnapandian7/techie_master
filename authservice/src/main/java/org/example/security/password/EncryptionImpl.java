package org.example.security.password;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionImpl  {

    private static final String AES_KEY = "TECHIE_SERVICE";

    public String encrypt(String data) {
        AesEncryptionImpl aes = new AesEncryptionImpl();
        System.out.println("Encrypting data--");
        return aes.encrypt(data, AES_KEY);
    }

    public String decrypt(String data) {
        AesEncryptionImpl aes = new AesEncryptionImpl();
        System.out.println("Decrypting data--");
        return aes.decrypt(data, AES_KEY);
    }

//    @Override
//    public String encode(CharSequence rawPassword) {
//        return this.encrypt(rawPassword.toString());
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return this.decrypt(encodedPassword).equals(rawPassword.toString());
//    }
}
