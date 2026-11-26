package za.co.municipality.smartservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.co.municipality.smartservice.model.ServiceRequest;
import za.co.municipality.smartservice.service.ServiceRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ServiceRequestRestController {
    private final ServiceRequestService service;

    public ServiceRequestRestController(ServiceRequestService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceRequest create(@Valid @RequestBody ServiceRequest request) {
        try {
            return service.addRequest(request);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @GetMapping
    public List<ServiceRequest> getAll() {
        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public ServiceRequest getById(@PathVariable Long id) {
        try {
            return service.getRequest(id);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
