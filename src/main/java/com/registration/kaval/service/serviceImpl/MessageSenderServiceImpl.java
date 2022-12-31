package com.registration.kaval.service.serviceImpl;

import com.registration.kaval.config.MessageSenderConfig;
import com.registration.kaval.model.SmsRequest;
import com.registration.kaval.service.MessageSenderService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class MessageSenderServiceImpl implements MessageSenderService {

    private final MessageSenderConfig messageSenderConfig;

    @Autowired
    public MessageSenderServiceImpl(MessageSenderConfig messageSenderConfig) {
        this.messageSenderConfig = messageSenderConfig;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(messageSenderConfig.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
        } else {
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
        }

    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        //TODO: Implement phone number validator
        return true;
    }
}

