package com.griddynamics.rwhite_rabbitmq_capstone.service.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.griddynamics.rwhite_rabbitmq_capstone.service.publisher.MessagePublisher;

/**
 * Component class responsible for scheduling and publishing messages at a fixed rate.
 */
@Log4j2
@Component
@RequiredArgsConstructor
public class MessageScheduler {

    private final MessagePublisher messagePublisher;
    private int messageCount = 0;

    /**
     * Method that publishes messages to the RabbitMQ queue at a fixed rate.
     * The rate is configured to be 100 milliseconds.
     */
    @Scheduled(fixedRate = 100)
    public void publishMessages() {
        // Create a new message with an incremented count
        String message = "Message " + (++messageCount);

        // Publish the message using the MessagePublisher service
        messagePublisher.publishMessage(message);

        // Log the published message
        log.info("Published message: {}", message);
    }

}