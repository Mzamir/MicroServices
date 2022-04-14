package com.example.notifications.controller;

import com.example.clients.notifications.SendingNotificationRequest;
import com.example.notifications.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification/")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService ;

    @PostMapping("send")
    public void sendNotification(@RequestBody SendingNotificationRequest notificationRequest){
        notificationService.saveNotification(notificationRequest);
    }
}
