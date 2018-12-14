package com.reactive.example.controller;

import com.reactive.example.model.NotificationModel;
import com.reactive.example.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.bus.Event;
import reactor.bus.EventBus;


@Controller
public class NotificationController {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/sendasync/{param}")
    @ResponseBody
    public String startNotification(@PathVariable Integer param){

        for (int i = 0; i < param ; i++) {

            NotificationModel data = new NotificationModel();
            data.setId(i);

            eventBus.notify("notification-agent", Event.wrap(data));

            System.out.println("Notification "+i+ " Submitted succesfully");

        }

        return "{All the messages submitted successfully}";
    }

    @RequestMapping("/sendsync/{param}")
    @ResponseBody
    public String startNotificationTraditional(@PathVariable Integer param){

        for (int i = 0; i < param ; i++) {

            NotificationModel data = new NotificationModel();
            data.setId(i);

            try {
                notificationService.initiateNotification(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Notification "+i+ " Submitted succesfully");

        }
        return "{All the messages submitted successfully}";
    }

}
