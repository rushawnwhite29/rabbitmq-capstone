package com.griddynamics.rwhite_rabbitmq_capstone.service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for publishing messages to a RabbitMQ queue.
 */
@Service
@RequiredArgsConstructor
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Publishes a message to the default RabbitMQ exchange.
     * The routing key and exchange are configured in the application properties.
     *
     * @param message the message to be published
     */
    public void publishMessage(String message) {
        // Send the message to the configured RabbitMQ exchange
        rabbitTemplate.convertAndSend(message);
    }

}