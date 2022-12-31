package com.registration.kaval.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSenderInitializer {

    @Autowired
    private final MessageSenderConfig messageSenderConfig;

    @Autowired
    public MessageSenderInitializer(MessageSenderConfig messageSenderConfig) {
        this.messageSenderConfig = messageSenderConfig;
        try {
            Twilio.init(
                    messageSenderConfig.getAccountSid(),
                    messageSenderConfig.getAuthToken()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
