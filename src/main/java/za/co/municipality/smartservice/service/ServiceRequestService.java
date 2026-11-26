package za.co.municipality.smartservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.municipality.smartservice.model.Notification;
import za.co.municipality.smartservice.model.ServiceRequest;
import za.co.municipality.smartservice.repository.ServiceRequestRepository;

import java.util.List;

@Service
public class ServiceRequestService {
    private final ServiceRequestRepository repository;
    private final NotificationSender notificationSender;

    public ServiceRequestService(ServiceRequestRepository repository,
                                 NotificationSender notificationSender) {
        this.repository = repository;
        this.notificationSender = notificationSender;
    }

    @Transactional
    public ServiceRequest addRequest(ServiceRequest request) {
        request.setStatus("SUBMITTED");
        ServiceRequest saved = repository.save(request);
        notificationSender.send(new Notification("SYSTEM",
                "Municipal request " + saved.getRequestId() + " was submitted."));
        return saved;
    }

    @Transactional(readOnly = true)
    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ServiceRequest getRequest(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No service request exists with ID " + id));
    }
}
