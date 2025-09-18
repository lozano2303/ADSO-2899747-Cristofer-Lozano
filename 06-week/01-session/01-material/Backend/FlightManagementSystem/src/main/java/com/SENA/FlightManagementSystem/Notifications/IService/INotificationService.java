package com.SENA.FlightManagementSystem.Notifications.IService;

import com.SENA.FlightManagementSystem.Notifications.Entity.Notification;
import com.SENA.FlightManagementSystem.Notifications.DTO.NotificationReqDto;
import com.SENA.FlightManagementSystem.Notifications.DTO.NotificationResDto;

public interface INotificationService extends INotificationBaseService<Notification, NotificationReqDto, NotificationResDto> {
}
