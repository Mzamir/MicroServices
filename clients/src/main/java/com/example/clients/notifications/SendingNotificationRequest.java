package com.example.clients.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendingNotificationRequest {

    private Integer customerId ;
    private String notificationText;

}
