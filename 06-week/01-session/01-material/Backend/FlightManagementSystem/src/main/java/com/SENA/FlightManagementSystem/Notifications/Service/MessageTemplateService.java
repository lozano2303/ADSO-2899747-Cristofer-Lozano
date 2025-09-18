package com.SENA.FlightManagementSystem.Notifications.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENA.FlightManagementSystem.Notifications.Entity.MessageTemplate;
import com.SENA.FlightManagementSystem.Notifications.IRepository.INotificationBaseRepository;
import com.SENA.FlightManagementSystem.Notifications.IService.IMessageTemplateService;
import com.SENA.FlightManagementSystem.Notifications.DTO.MessageTemplateReqDto;
import com.SENA.FlightManagementSystem.Notifications.DTO.MessageTemplateResDto;

@Service
public class MessageTemplateService extends NotificationBaseService<MessageTemplate, MessageTemplateReqDto, MessageTemplateResDto> implements IMessageTemplateService {

    @Override
    protected INotificationBaseRepository<MessageTemplate, String> getRepository() {
        return repository;
    }

    @Autowired
	private INotificationBaseRepository<MessageTemplate, String> repository;

    @Override
    public MessageTemplateResDto mapToResDto(MessageTemplate entity) {
        return MessageTemplateResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .subjectTemplate(entity.getSubjectTemplate())
                .bodyTemplate(entity.getBodyTemplate())
                .build();
    }

    @Override
    public MessageTemplate mapToEntity(MessageTemplateReqDto dto) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setCode(dto.getCode());
        messageTemplate.setName(dto.getName());
        messageTemplate.setSubjectTemplate(dto.getSubjectTemplate());
        messageTemplate.setBodyTemplate(dto.getBodyTemplate());
        return messageTemplate;
    }
}
