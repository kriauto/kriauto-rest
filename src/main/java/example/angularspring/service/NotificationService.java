package example.angularspring.service;

import java.util.List;

import example.angularspring.dto.Notification;

public interface NotificationService {
	public void addNotification(Notification notification);
	public List<Notification> getNotificationByDevice(Integer deviceid);
}
