package za.co.municipality.smartservice.model;

import java.util.HashMap;
import java.util.Map;

/** Example in-memory index for quick lookup by request ID. */
public class ServiceRequestIndex {
    private final Map<Long, ServiceRequest> requestsById = new HashMap<>();

    public void add(ServiceRequest request) {
        if (request.getRequestId() != null) {
            requestsById.put(request.getRequestId(), request);
        }
    }

    public ServiceRequest find(Long requestId) {
        return requestsById.get(requestId);
    }
}
