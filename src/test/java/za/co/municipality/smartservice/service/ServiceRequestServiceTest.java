package za.co.municipality.smartservice.service;

import org.junit.jupiter.api.Test;
import za.co.municipality.smartservice.model.ServiceRequest;
import za.co.municipality.smartservice.repository.ServiceRequestRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceRequestServiceTest {
    @Test
    void addRequestSavesRequestAndReturnsSavedEntity() {
        ServiceRequestRepository repository = mock(ServiceRequestRepository.class);
        NotificationSender sender = mock(NotificationSender.class);
        ServiceRequest input = new ServiceRequest("Amina Daniels", "WATER_LEAK", "Pipe is leaking.");
        ServiceRequest saved = new ServiceRequest("Amina Daniels", "WATER_LEAK", "Pipe is leaking.");
        saved.setRequestId(10L);
        when(repository.save(input)).thenReturn(saved);

        ServiceRequestService service = new ServiceRequestService(repository, sender);
        ServiceRequest result = service.addRequest(input);

        assertEquals(10L, result.getRequestId());
        verify(repository).save(input);
        verify(sender).send(any());
    }

    @Test
    void getAllRequestsReturnsRepositoryResults() {
        ServiceRequestRepository repository = mock(ServiceRequestRepository.class);
        NotificationSender sender = mock(NotificationSender.class);
        when(repository.findAll()).thenReturn(List.of(new ServiceRequest("A", "ELECTRICITY", "No power")));
        ServiceRequestService service = new ServiceRequestService(repository, sender);
        assertEquals(1, service.getAllRequests().size());
    }
}
