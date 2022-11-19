package com.mewada.rohit.assessment.producer;

import com.mewada.rohit.assessment.constants.KafkaConstants;
import com.mewada.rohit.assessment.model.KafkaReadyRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, KafkaReadyRecord> kafkaTemplate;

    public void sendMessage(KafkaReadyRecord kafkaReadyRecord){
        log.info(String.format("Message sent -> %s", kafkaReadyRecord));
        kafkaTemplate.send(KafkaConstants.READY_TOPIC, kafkaReadyRecord);
    }
}
