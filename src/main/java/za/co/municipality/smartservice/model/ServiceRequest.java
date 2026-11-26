package za.co.municipality.smartservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String citizenName;

    @NotBlank
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String requestType;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 30)
    private String status = "SUBMITTED";

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public ServiceRequest() { }

    public ServiceRequest(String citizenName, String requestType, String description) {
        this.citizenName = citizenName;
        this.requestType = requestType;
        this.description = description;
        this.status = "SUBMITTED";
        this.createdAt = LocalDateTime.now();
    }

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public String getCitizenName() { return citizenName; }
    public void setCitizenName(String citizenName) { this.citizenName = citizenName; }
    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
