package ru.grsp.backend.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.grsp.backend.controller.iface.OrderController;
import ru.grsp.backend.model.Product;
import ru.grsp.backend.service.OrderingService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class OrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    OrderingService orderingService;

    @KafkaListener(topics = "ocstore.ocstore.oc_order")
    public void listen(@Payload String message) throws IOException {
        //log.info(message);
        try {

            readToObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readToObject(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(message);
        String jsonExp = "$.payload.after";
        LinkedHashMap payload = JsonPath.read(actualObj.toString(), jsonExp);
        //log.info("payload: {}", payload);
        log.info("payload: {}", payload.get("order_id"));
        Integer orderId = Integer.parseInt(payload.get("order_id").toString());
        Collection<Integer> products = orderingService.findAllProductsByOrderId(orderId);
        log.info("products: {}", Arrays.toString(products.toArray()));

    }

}
