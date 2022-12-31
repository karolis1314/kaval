package com.registration.kaval.service;

import com.registration.kaval.model.SmsRequest;

public interface MessageSenderService {

    void sendSms(SmsRequest smsRequest);
}
