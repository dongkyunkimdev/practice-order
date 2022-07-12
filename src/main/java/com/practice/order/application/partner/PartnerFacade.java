package com.practice.order.application.partner;

import com.practice.order.domain.notification.NotificationService;
import com.practice.order.domain.partner.PartnerCommand;
import com.practice.order.domain.partner.PartnerInfo;
import com.practice.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");

        return partnerInfo;
    }

}
