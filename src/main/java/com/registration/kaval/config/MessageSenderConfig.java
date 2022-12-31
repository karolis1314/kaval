package com.registration.kaval.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageSenderConfig {

    private String accountSid = "AC32a2e5b7bf4da0a095428b9a9cf5853c";
    private String authToken = "08fab1c6317a00ceb037c7365ece7a2a";
    private String trialNumber = "+16692805381";

}