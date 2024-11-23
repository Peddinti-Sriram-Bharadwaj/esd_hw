package com.sriram9217.esdtask.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncryptionService {
    private final PasswordEncoder passwordEncoder;

    public String encode (String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validates (String password, String encryptedPassword ) {
        System.out.println("at the validates in encryption service");
        return passwordEncoder.matches(password, encryptedPassword);
    }
}
