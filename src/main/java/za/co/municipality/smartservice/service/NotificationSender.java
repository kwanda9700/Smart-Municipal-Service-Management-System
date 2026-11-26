package za.co.municipality.smartservice.service;

import za.co.municipality.smartservice.model.Notification;

public interface NotificationSender {
    void send(Notification notification);
}
