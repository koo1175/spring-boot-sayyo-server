//package com.pj.sayyo.service.search;
//
//import com.pj.sayyo.model.search.dto.SearchDto;
//import com.pj.sayyo.model.search.mapper.SearchRepository;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Arrays;
//import java.util.Optional;
//import java.util.Properties;
//
//@Component
//public class KafkaMessageConsumer {
//    @Autowired
//    private SearchRepository searchRepository;
//
//    @PostConstruct
//    public void consume() {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "sayo");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("sayo"));
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                String title = record.value();
//                Optional<SearchDto> optionalSearchDto = searchRepository.findByTitle(title);
//
////                if (optionalSearchDto.isPresent()) {
////                    // 'title'이 DB에 이미 존재하는 경우: count를 1 증가시키고 업데이트
////                    SearchDto existingSearchDto = optionalSearchDto.get();
////                    existingSearchDto.setCount(existingSearchDto.getCount() + 1);
////                    searchRepository.save(existingSearchDto);
////                    System.out.println("Updated DB: " + existingSearchDto.getTitle() + ", count = " + existingSearchDto.getCount());
////                } else {
////                    // 'title'이 DB에 없는 경우: 새로운 SearchDto 객체를 생성하고 count를 0으로 설정한 후 삽입
////                    SearchDto newSearchDto = new SearchDto();
////                    newSearchDto.setTitle(title);
////                    newSearchDto.setCount(0);
////                    searchRepository.save(newSearchDto);
////                    System.out.println("Inserted into DB: " + newSearchDto.getTitle() + ", count = " + newSearchDto.getCount());
////                }
//
//            }
//        }
//    }
//}
