package com.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.entities.Notification;
import com.notification.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    

    @Autowired
	NotificationService notificationService;
	
	@PostMapping("/send")
	public boolean notification(@RequestBody Notification data) {
		return notificationService.sendNotification(data);
	}
}
