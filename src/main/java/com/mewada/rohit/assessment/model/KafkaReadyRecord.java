package com.mewada.rohit.assessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class KafkaReadyRecord {
    @JsonProperty
    private String recordNumber;
    @JsonProperty
    private String payload;
}
