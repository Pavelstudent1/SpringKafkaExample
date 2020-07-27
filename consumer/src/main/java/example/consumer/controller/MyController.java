package example.consumer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.consumer.dto.FrontMessage;
import example.consumer.dto.KafkaMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    private static final Logger LOG = LoggerFactory.getLogger(MyController.class);

    private final KafkaTemplate<String, KafkaMessageDto> kafkaTemplate;

    public MyController(KafkaTemplate<String, KafkaMessageDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(path = "/message")
    void send(@RequestBody final FrontMessage message) {
        LOG.info("About to send: '{}'", message);
        KafkaMessageDto msg = new KafkaMessageDto(
                message.getId(),
                message.getMessage(),
                new Date());
        kafkaTemplate.send("test-new-topic-1", msg);
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        KafkaMessageDto msg = new KafkaMessageDto(
                1L,
                "test",
                new Date());
        String res = mapper.writeValueAsString(msg);
        System.out.println(res);

        String value = "{\"id\":1,\"message\":\"test\",\"time\":\"27-07-2020 12:26:28\"}";
        KafkaMessageDto dto = mapper.readValue(value, KafkaMessageDto.class);
        System.out.println(dto);
    }
}
