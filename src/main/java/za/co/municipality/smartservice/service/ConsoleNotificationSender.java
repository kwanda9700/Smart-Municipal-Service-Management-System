package za.co.municipality.smartservice.service;

import org.springframework.stereotype.Component;
import za.co.municipality.smartservice.model.Notification;

@Component
public class ConsoleNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        // Demonstration implementation. A production system can replace this with SMS/email.
        System.out.println("[" + notification.getChannel() + "] " + notification.getMessage());
    }
}
