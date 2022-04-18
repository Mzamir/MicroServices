package com.example.notifications.service;

import com.example.clients.notifications.SendingNotificationRequest;
import com.example.notifications.entities.NotificationEntity;
import com.example.notifications.repository.NotificationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationsRepository repository;

    public void saveNotification(SendingNotificationRequest notificationRequest) {
        log.info("saveNotification " + notificationRequest);
        repository.save(NotificationEntity.builder()
                .customerId(notificationRequest.getCustomerId())
                .notificationText(notificationRequest.getNotificationText())
                .createdAt(LocalDateTime.now())
                .build());
    }
}
