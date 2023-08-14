package com.lcwd.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reminder-service")
public interface ReminderClient {
    @PostMapping("/reminders/send-sms")
    void sendSMSReminder(@RequestParam("contactInfo") String contactInfo);
    @PostMapping("/reminders/send-email")
    void sendEmailReminder(@RequestParam("contactInfo") String contactInfo);
}