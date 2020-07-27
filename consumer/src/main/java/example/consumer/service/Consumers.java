package example.consumer.service;

import example.consumer.dto.KafkaMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumers {

    private static final Logger LOG = LoggerFactory.getLogger(Consumers.class);

    @KafkaListener(topics = "test-new-topic-1", groupId = "test-new-topic-1-group-id")
    public void consumer1(final KafkaMessageDto message) {
        LOG.info("CONSUMER #1: >>> {}", message);
    }
}
