package com.marcos.mcp.spring_security_jwt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    private String prefix;
    private String key;
    private Long expiration;

    
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Long getExpiration() {
        return expiration;
    }
    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
