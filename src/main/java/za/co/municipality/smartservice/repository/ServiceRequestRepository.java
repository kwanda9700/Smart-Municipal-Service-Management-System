package za.co.municipality.smartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.municipality.smartservice.model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
}
