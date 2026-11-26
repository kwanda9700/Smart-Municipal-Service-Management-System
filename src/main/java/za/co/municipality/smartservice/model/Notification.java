package za.co.municipality.smartservice.model;

public class Notification {
    private String channel;
    private String message;

    public Notification(String channel, String message) {
        this.channel = channel; this.message = message;
    }
    public String getChannel() { return channel; }
    public String getMessage() { return message; }
}
