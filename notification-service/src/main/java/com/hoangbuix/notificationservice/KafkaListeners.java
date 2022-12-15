package com.hoangbuix.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
/**
 * @author bvhoang2
 * @version 1.0
 * @since 16/11/2022 3:44 PM
 **/
@Component
@Slf4j
public class KafkaListeners {

    @KafkaListener(topics = "notificationTopic", groupId = "notificationId")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        // send out an email notification
        log.info("Received Notification for Order - {}", orderPlacedEvent.getOrderNumber());
    }
}
