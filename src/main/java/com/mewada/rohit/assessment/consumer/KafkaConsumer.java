package com.mewada.rohit.assessment.consumer;

import com.mewada.rohit.assessment.constants.KafkaConstants;
import com.mewada.rohit.assessment.model.QueueData;
import com.mewada.rohit.assessment.model.Records;
import com.mewada.rohit.assessment.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.example.model.KafkaReadyRecord;
import org.example.model.KafkaWaitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class KafkaConsumer {

    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    KafkaProducer kafkaProducer;

    @KafkaListener(topics = KafkaConstants.WAIT_TOPIC,
            groupId = KafkaConstants.GROUP_ID)
    public void consume(KafkaWaitRecord kafkaWaitRecord){

        log.info("RECIVED OBJECT {}",kafkaWaitRecord);

        log.info("Message received -> {} {} {}",
                kafkaWaitRecord.getRecordNumber(),
                kafkaWaitRecord.getDelayMs(),
                kafkaWaitRecord.getPayload());


        //Do What ever we want to doo Like connecting to outside party

        if(kafkaWaitRecord.getDelayMs()>0){
            restTemplate.postForObject("http://localhost:8081/postRecord",kafkaWaitRecord, QueueData.class);
        } else {

            KafkaReadyRecord kafkaReadyRecord = new KafkaReadyRecord();
                kafkaReadyRecord.setRecordNumber(kafkaWaitRecord.getRecordNumber());
                kafkaReadyRecord.setPayload(kafkaWaitRecord.getPayload());
                kafkaProducer.sendMessage(kafkaReadyRecord);
        }

//        restTemplate.postForObject("http://localhost:8081/postRecord",kafkaWaitRecord, QueueData.class);
//
//        Records records = restTemplate.getForObject("http://localhost:8081/getRecord", Records.class);
//
//        if (records==null || records.getRecordList().isEmpty()){
//            log.info("Waiting for records timeout");
//        } else{
//            for(KafkaWaitRecord record : records.getRecordList()){
//                log.info("record {} ",record.getDelayMs());
//                KafkaReadyRecord kafkaReadyRecord = new KafkaReadyRecord();
//                kafkaReadyRecord.setRecordNumber(record.getRecordNumber());
//                kafkaReadyRecord.setPayload(record.getPayload());
//                kafkaProducer.sendMessage(kafkaReadyRecord);
//            }
//        }

    }

    @KafkaListener(topics = KafkaConstants.READY_TOPIC,
            groupId = KafkaConstants.GROUP_ID,
    clientIdPrefix = "ready")
    public void consume(KafkaReadyRecord kafkaReadyRecord){
        log.info("Message received -> {} {}",
                kafkaReadyRecord.getRecordNumber(),
                kafkaReadyRecord.getPayload());
    }
}
