package com.practice.order.infrastructure;

import com.practice.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificatrionExecutor implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("sendKakao");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("sendSms");
    }

}
