package com.handson.labs.graphql.configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
@Slf4j
public class EncryptionConfig {

    @Value("${jasypt.encryptor.password}")
    private String encryptorPassword;

    @Value("${jasypt.encryptor.algorithm}")
    private String encryptorAlgorithm;

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(encryptorPassword);
        encryptor.setAlgorithm(encryptorAlgorithm);
        return encryptor;
    }
}
