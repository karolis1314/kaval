package com.registration.kaval.controller;

import com.registration.kaval.model.SmsRequest;
import com.registration.kaval.service.serviceImpl.MessageSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sms")
public class MessageSenderController {

    private final MessageSenderServiceImpl messageSenderService;

    @Autowired
    public MessageSenderController(MessageSenderServiceImpl messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        messageSenderService.sendSms(smsRequest);
    }
}
