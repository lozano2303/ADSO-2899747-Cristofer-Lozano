package com.SENA.FlightManagementSystem.Notifications.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SENA.FlightManagementSystem.Notifications.Entity.Notification;
import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Notifications.IRepository.INotificationBaseRepository;
import com.SENA.FlightManagementSystem.Notifications.IService.INotificationService;
import com.SENA.FlightManagementSystem.Notifications.DTO.NotificationReqDto;
import com.SENA.FlightManagementSystem.Notifications.DTO.NotificationResDto;
import com.SENA.FlightManagementSystem.Security.IService.IPersonService;

@Service
public class NotificationService extends NotificationBaseService<Notification, NotificationReqDto, NotificationResDto> implements INotificationService {

    @Override
    protected INotificationBaseRepository<Notification, String> getRepository() {
        return repository;
    }

    @Autowired
	private INotificationBaseRepository<Notification, String> repository;

    @Autowired
    private IPersonService personService;

    @Override
    public NotificationResDto mapToResDto(Notification entity) {
        return NotificationResDto.builder()
                .id(entity.getId())
                .personId(entity.getPerson() != null ? entity.getPerson().getId() : null)
                .personName(entity.getPerson() != null ? entity.getPerson().getFirstName() + " " + entity.getPerson().getLastName() : null)
                .channel(entity.getChannel())
                .subject(entity.getSubject())
                .message(entity.getMessage())
                .sentAt(entity.getSentAt())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Notification mapToEntity(NotificationReqDto dto) {
        Notification notification = new Notification();
        notification.setChannel(dto.getChannel());
        notification.setSubject(dto.getSubject());
        notification.setMessage(dto.getMessage());
        notification.setSentAt(dto.getSentAt());
        notification.setStatus(dto.getStatus());

        if (dto.getPersonId() != null) {
            try {
                Person person = personService.findById(dto.getPersonId()).orElse(null);
                notification.setPerson(person);
            } catch (Exception e) {
                // Log error or handle appropriately
                notification.setPerson(null);
            }
        }

        return notification;
    }
}
