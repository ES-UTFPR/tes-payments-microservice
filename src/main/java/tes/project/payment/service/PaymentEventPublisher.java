package tes.project.payment.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tes.project.payment.config.RabbitMQConfig;

@Service
public class PaymentEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishPaymentConfirmedEvent(Long orderId) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.PAYMENT_CONFIRMED_QUEUE, orderId);
    }
}