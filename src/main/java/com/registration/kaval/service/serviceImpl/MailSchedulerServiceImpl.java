package com.registration.kaval.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.logging.Logger;

@Component
@EnableAsync
@EnableScheduling
public class MailSchedulerServiceImpl {

    Logger logger = Logger.getLogger(MailSchedulerServiceImpl.class.getName());

    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    @Autowired
    private UserServiceImpl userService;


//    @Scheduled(cron = "*/10 * * * * *")
//    @Async
//    public void logging() {
//        Date date = Date.valueOf(LocalDate.now());
//        Date date1 = Date.valueOf(LocalDate.now().minusDays(1));
//        logger.info(date1.toString());
//        logger.info(date.toString());
//    }

    @Scheduled(cron = "0 0 12 * * ?")
    @Async
    public void sendEmail() {
        try {
            userService.findAllUser().forEach(user -> {
                if (user.getAppointments().size() > 0) {
                    user.getAppointments().forEach(appointment -> {
                        if (appointment.getDate().equals(LocalDate.now().minusDays(1))) {
                            String appointmentDateTime = appointment.getDate() + " " + appointment.getTime();
                            emailSenderService.sendEmail(user.getEmail(), "Appointment Reminder",
                                    "You have an appointment tomorroew at " + appointmentDateTime);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
