package example.consumer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class KafkaMessageDto implements Serializable {
    private final Long id;
    private final String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final Date time;

    @JsonCreator
    public KafkaMessageDto(
            @JsonProperty("id") final Long id,
            @JsonProperty("message") final String message,
            @JsonProperty("time") final Date time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

}
