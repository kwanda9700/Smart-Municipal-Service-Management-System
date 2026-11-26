package za.co.municipality.smartservice.model;

public class RequestDetails {
    private String description;
    private String locationLandmark;
    private String urgency;

    public RequestDetails() { }
    public RequestDetails(String description, String locationLandmark, String urgency) {
        this.description = description; this.locationLandmark = locationLandmark; this.urgency = urgency;
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocationLandmark() { return locationLandmark; }
    public void setLocationLandmark(String locationLandmark) { this.locationLandmark = locationLandmark; }
    public String getUrgency() { return urgency; }
    public void setUrgency(String urgency) { this.urgency = urgency; }
}
