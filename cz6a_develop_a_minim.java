import java.awt.*;
import javax.swing.*;
import java.util.*;

public class cz6a_develop_a_minim {
  // Data Model: Notification
  public static class Notification {
    String title;
    String message;
    int priority; // 1-5, 1 is lowest, 5 is highest
    long timestamp;

    public Notification(String title, String message, int priority) {
      this.title = title;
      this.message = message;
      this.priority = priority;
      this.timestamp = System.currentTimeMillis();
    }
  }

  // Data Model:Notifier
  public static class Notifier {
    ArrayList<Notification> notifications;
    int maxNotifications;

    public Notifier(int maxNotifications) {
      this.maxNotifications = maxNotifications;
      this.notifications = new ArrayList<>();
    }

    public void addNotification(Notification notification) {
      notifications.add(notification);
      if (notifications.size() > maxNotifications) {
        Collections.sort(notifications, (n1, n2) -> Long.compare(n2.timestamp, n1.timestamp));
        notifications.subList(maxNotifications, notifications.size()).clear();
      }
    }

    public ArrayList<Notification> getNotifications() {
      return notifications;
    }
  }

  public static void main(String[] args) {
    // Example usage
    Notifier notifier = new Notifier(5);
    notifier.addNotification(new Notification("Low Priority", "This is a low priority notification", 1));
    notifier.addNotification(new Notification("High Priority", "This is a high priority notification", 5));
    notifier.addNotification(new Notification("Medium Priority", "This is a medium priority notification", 3));

    for (Notification notification : notifier.getNotifications()) {
      System.out.println(notification.title + ": " + notification.message);
    }
  }
}