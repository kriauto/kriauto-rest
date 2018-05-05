package example.angularspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.angularspring.dao.NotificationDao;
import example.angularspring.dto.Notification;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationDao notificationdao;

	@Override
	public void addNotification(Notification notification) {
		// TODO Auto-generated method stub
		notificationdao.addNotification(notification);
		
	}

	@Override
	public List<Notification> getNotificationByDevice(Integer deviceid) {
		// TODO Auto-generated method stub
		return notificationdao.getNotificationByDevice(deviceid);
	}

}
