package com.griddynamics.rwhite_rabbitmq_capstone.service.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

/**
 * Service class that listens for messages from a RabbitMQ queue.
 */
@Log4j2
@Service
public class MessageListener {

    /**
     * Method to receive messages from the specified RabbitMQ queue.
     * The queue name is configured in the application properties.
     *
     * @param message the message received from the queue
     */
    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void receiveMessage(String message) {
        // Log the received message
        log.info("Received message: {}", message);
    }

}