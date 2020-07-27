package example.consumer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
public class CommonConfig {

    @Bean
    KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = Map.of(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(props);
    }

    @Bean
    NewTopic newTopic() {
        return new NewTopic("test-new-topic-1", 1, (short) 1);
    }
}
