package p02_services.before;

public class EmailNotificationService {

    private boolean isActive;

    public EmailNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    public void sendNotification() {

    }

    public boolean isActive() {
        return this.isActive;
    }
}
