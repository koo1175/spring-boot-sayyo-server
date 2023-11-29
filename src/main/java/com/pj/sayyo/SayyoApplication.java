package com.pj.sayyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@SpringBootApplication
@EnableScheduling
public class SayyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayyoApplication.class, args);
//		Properties props = new Properties();
//		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "sayo");
//		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		// ... more properties ...
//
//		StreamsBuilder builder = new StreamsBuilder();
//		KStream<String, String> source = builder.stream("sayo");
//		// ... more stream processing ...
//
//		KafkaStreams streams = new KafkaStreams(builder.build(), props);
//		streams.start();
	}

}
