//package com.pj.sayyo.controller.search;
//
//import com.pj.sayyo.service.search.KafkaConsumerService;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//public class MessageListener {
//    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
//
//    @Autowired
//    private KafkaConsumerService kafkaConsumerService;
//
//    @KafkaListener(topics = "sayo")
//    public void messageListener(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
//        log.info("### record: " + record.toString());
//        log.info("### topic: " + record.topic() + ", value: " + record.value() + ", offset: " + record.offset());
//
//        // 메시지를 저장합니다.
//        kafkaConsumerService.saveMessage(record.value());
//
//        // kafka 메시지 읽어온 곳까지 commit. (이 부분을 하지 않으면 메시지를 소비했다고 commit 된 것이 아니므로 계속 메시지를 읽어온다)
//        acknowledgment.acknowledge();
//    }
//}
