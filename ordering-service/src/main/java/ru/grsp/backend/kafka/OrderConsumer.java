package ru.grsp.backend.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.grsp.backend.model_jooq.tables.records.OcOrder;

import java.io.IOException;
import java.sql.Connection;
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
        String jsonExp = "$.payload.after";
        LinkedHashMap payload = JsonPath.read(actualObj.toString(), jsonExp);
        log.info("payload: {}", payload);

        DataBaseReader dbr = new DataBaseReader();
        Connection conn = dbr.returnMysql();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<? extends Record1<?>> result = create.select((SelectField<?>) OcOrder.OC_ORDER).from().fetch();
        log.info(result.toString());
    }
}
