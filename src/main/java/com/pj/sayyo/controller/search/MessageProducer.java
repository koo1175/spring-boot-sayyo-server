//package com.pj.sayyo.controller.search;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pj.sayyo.service.search.KafkaConsumerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RequestMapping("/kafka")
//@RestController
//@RequiredArgsConstructor
//public class MessageProducer {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @PostMapping("/producer")
//    public void publishMessage(@RequestBody Map<String, String> message) throws JsonProcessingException {
//        System.out.println("Received message: " + message);
//        String keyword = message.get("keyword");
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, String> map = new HashMap<>();
//        map.put("keyword", keyword);
//        String jsonMessage = mapper.writeValueAsString(map);
//        kafkaTemplate.send("sayo", jsonMessage);
//    }
//
//
//}
