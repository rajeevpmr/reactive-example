package com.reactive.example.service;

import com.reactive.example.model.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;

@Service
public class NotificationConsumer implements reactor.fn.Consumer<Event<NotificationModel>> {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void accept(Event<NotificationModel> notificationModelEvent) {
        NotificationModel notification = notificationModelEvent.getData();

        try{
            notificationService.initiateNotification(notification);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
