package com.mewada.rohit.assessment.consumer;

import com.mewada.rohit.assessment.constants.KafkaConstants;
import com.mewada.rohit.assessment.model.KafkaWaitRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableKafka
public class KafkaConsumer {

//    RestTemplate restTemplate = new RestTemplate();
//    @Autowired
//    KafkaProducer kafkaProducer;

    @KafkaListener(topics = KafkaConstants.WAIT_TOPIC,
            groupId = KafkaConstants.GROUP_ID)
    public void consume(Object kafkaWaitRecord){

        log.info("RECIVED OBJECT {}",kafkaWaitRecord);

//        log.info("Message received -> {} {} {}",
//                kafkaWaitRecord.getRecordNumber(),
//                kafkaWaitRecord.getDelayMs(),
//                kafkaWaitRecord.getPayload());

//        restTemplate.postForObject("http://localhost:8081/postRecord",kafkaWaitRecord, QueueData.class);
//
//        List<KafkaWaitRecord> records = restTemplate.getForObject("http://localhost:8081/getRecord", List.class);

//        for(KafkaWaitRecord record : records){
//            log.info("record {} ",record.getDelayMs());
//            KafkaReadyRecord kafkaReadyRecord = new KafkaReadyRecord();
//            kafkaReadyRecord.setRecordNumber(record.getRecordNumber());
//            kafkaReadyRecord.setPayload(record.getPayload());
//            kafkaProducer.sendMessage(kafkaReadyRecord);
//        }
    }

//    @KafkaListener(topics = KafkaConstants.READY_TOPIC,
//            groupId = KafkaConstants.GROUP_ID,
//    clientIdPrefix = "ready")
//    public void consume(KafkaReadyRecord kafkaReadyRecord){
//        log.info("Message received -> {} {}",
//                kafkaReadyRecord.getRecordNumber(),
//                kafkaReadyRecord.getPayload());
//    }
}
