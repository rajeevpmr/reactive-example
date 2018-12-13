package com.reactive.example.service;

import com.reactive.example.model.NotificationModel;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void initiateNotification(NotificationModel notification) throws InterruptedException {

        System.out.println("Notification service started for Notification ID : " + notification.getId());

        Thread.sleep(5000);

        System.out.println("Notification service ended for Notification ID : " + notification.getId());
    }
}
