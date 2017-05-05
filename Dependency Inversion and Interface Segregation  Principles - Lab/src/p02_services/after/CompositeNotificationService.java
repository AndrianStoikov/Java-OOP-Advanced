package p02_services.after;

public class CompositeNotificationService implements NotificationService {

    private NotificationService[] notificationServices;

    public CompositeNotificationService(NotificationService... notificationServices) {
        this.notificationServices = notificationServices;
    }

    @Override
    public void sendNotification() {
        for (NotificationService notificationService : notificationServices) {
            if (notificationService.isActive()) {
                notificationService.sendNotification();
            }
        }
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
