package com.reactive.example.service;

import com.reactive.example.model.NotificationModel;

public interface NotificationService {

    void initiateNotification(NotificationModel notification) throws InterruptedException;

}
