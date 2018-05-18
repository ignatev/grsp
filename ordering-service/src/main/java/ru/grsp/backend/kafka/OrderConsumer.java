package ru.grsp.backend.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedHashMap;

@Component
public class OrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "ocstore.ocstore.oc_order")
    public void listen(@Payload String message) throws IOException {
        log.info(message);
        try {
            readToObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readToObject(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(message);
        //log.info(actualObj.toString());
        //log.info("processing : {}", message);
        String jsonExp = "$.payload.after";
        LinkedHashMap payload = JsonPath.read(actualObj.toString(), jsonExp);
        //JsonNode node = mapper.readTree(payload);
        log.info("payload: {}", payload);
    }
}
