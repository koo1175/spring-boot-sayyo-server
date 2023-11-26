//package com.pj.sayyo.service.search;
//
//import com.pj.sayyo.model.search.dto.SearchDto;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.KTable;
//import org.apache.kafka.streams.kstream.TimeWindows;
//import org.apache.kafka.streams.kstream.Windowed;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.time.Duration;
//import java.util.Properties;
//
//@Service
//public class KeywordCountService {
//
//    @Autowired
//    private SearchService searchService;
//
//    @PostConstruct
//    public void start() {
//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "keyword-count-app");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//        StreamsBuilder builder = new StreamsBuilder();
//        KStream<String, String> keywordStream = builder.stream("keywords");
//
//        KTable<Windowed<String>, Long> keywordCounts = keywordStream
//                .map((key, value) -> new KeyValue<>(value, value))
//                .groupByKey()
//                .windowedBy(TimeWindows.of(Duration.ofMinutes(1)))
//                .count();
//
//        keywordCounts.toStream((key, value) -> key.key()).foreach((keyword, count) -> {
//            if (count >= 3) {
//                SearchDto searchDto = new SearchDto();
//                searchDto.setTitle(keyword);
//                searchService.saveOrUpdate(keyword);
//            }
//        });
//
//        KafkaStreams streams = new KafkaStreams(builder.build(), props);
//
//        // JVM이 종료될 때 KafkaStreams 인스턴스를 정상적으로 종료하도록 설정
//        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//
//        streams.start();
//    }
//}
