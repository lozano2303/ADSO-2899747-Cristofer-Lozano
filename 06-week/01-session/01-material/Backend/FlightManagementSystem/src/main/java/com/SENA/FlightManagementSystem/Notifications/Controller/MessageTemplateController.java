package com.SENA.FlightManagementSystem.Notifications.Controller;

import com.SENA.FlightManagementSystem.Notifications.Entity.MessageTemplate;
import com.SENA.FlightManagementSystem.Notifications.IService.IMessageTemplateService;
import com.SENA.FlightManagementSystem.Notifications.DTO.MessageTemplateReqDto;
import com.SENA.FlightManagementSystem.Notifications.DTO.MessageTemplateResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/message-template")
public class MessageTemplateController extends ANotificationBaseController<MessageTemplate, MessageTemplateReqDto, MessageTemplateResDto, IMessageTemplateService>{

    public MessageTemplateController(IMessageTemplateService service) {
        super(service, "MessageTemplate" );
    }
}
