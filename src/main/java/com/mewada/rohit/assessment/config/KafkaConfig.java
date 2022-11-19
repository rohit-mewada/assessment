package com.mewada.rohit.assessment.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

//    @Bean
//    public NewTopic KafkaWaitTopic(){
//        return TopicBuilder.name("wait_topic")
//                .build();
//    }

//    @Bean
//    public ConsumerFactory<String, KafkaWaitRecord> consumerFactory(KafkaProperties kafkaProperties){
//        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(),new StringDeserializer(),new JsonDeserializer<>(KafkaWaitRecord.class));
//    }
//
//    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,KafkaWaitRecord>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties){
//        ConcurrentKafkaListenerContainerFactory<String,KafkaWaitRecord> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory(kafkaProperties));
//        return factory;
//    }



//    @Bean
//    public NewTopic KafkaReadyTopic(){
//        return TopicBuilder.name("ready_topic")
//                .build();
//    }
}
