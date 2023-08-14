package com.remainder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/notifications/send-default")
    void sendDefaultReminder(@RequestParam("contactInfo") String contactInfo);

    @PostMapping("/notifications/send-sms")
    void sendSMSReminder(@RequestParam("contactInfo") String contactInfo);

    @PostMapping("/notifications/send-email")
    void sendEmailReminder(@RequestParam("contactInfo") String contactInfo);
}
