package example.angularspring.dao;

import java.util.List;

import example.angularspring.dto.Notification;

public interface NotificationDao {
	public void addNotification(Notification notification);
	public List<Notification> getNotificationByDevice(Integer deviceid);

}
