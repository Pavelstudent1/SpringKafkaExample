package example.consumer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FrontMessage {

    private final Long id;
    private final String message;

    @JsonCreator
    public FrontMessage(@JsonProperty("id") final Long id,
                        @JsonProperty("message") final String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }
}
