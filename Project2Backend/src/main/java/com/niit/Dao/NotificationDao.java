package com.niit.Dao;

import java.util.List;

import com.niit.Models.Notification;

public interface NotificationDao {
	void addNotification(Notification notification);
	List<Notification>  getAllNotification(String email);
	Notification getNotification(int notificationId);
	void updateNotification(int notificationId);
}
