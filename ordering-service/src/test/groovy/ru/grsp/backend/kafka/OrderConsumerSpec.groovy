package ru.grsp.backend.kafka

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import spock.lang.Specification

class OrderConsumerSpec extends Specification {


    def "parse payload using jsonpath"() {
        given:
        def message = "{\"schema\":{\"type\":\"struct\",\"fields\":[{\"type\":\"struct\",\"fields\":[{\"type\":\"int32\",\"optional\":false,\"field\":\"order_product_id\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"order_id\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"product_id\"},{\"type\":\"string\",\"optional\":false,\"field\":\"name\"},{\"type\":\"string\",\"optional\":false,\"field\":\"model\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"quantity\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"price\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"total\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"tax\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"reward\"}],\"optional\":true,\"name\":\"ocstore.ocstore.oc_order_product.Value\",\"field\":\"before\"},{\"type\":\"struct\",\"fields\":[{\"type\":\"int32\",\"optional\":false,\"field\":\"order_product_id\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"order_id\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"product_id\"},{\"type\":\"string\",\"optional\":false,\"field\":\"name\"},{\"type\":\"string\",\"optional\":false,\"field\":\"model\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"quantity\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"price\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"total\"},{\"type\":\"bytes\",\"optional\":false,\"name\":\"org.apache.kafka.connect.data.Decimal\",\"version\":1,\"parameters\":{\"scale\":\"4\"},\"field\":\"tax\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"reward\"}],\"optional\":true,\"name\":\"ocstore.ocstore.oc_order_product.Value\",\"field\":\"after\"},{\"type\":\"struct\",\"fields\":[{\"type\":\"string\",\"optional\":true,\"field\":\"version\"},{\"type\":\"string\",\"optional\":false,\"field\":\"name\"},{\"type\":\"int64\",\"optional\":false,\"field\":\"server_id\"},{\"type\":\"int64\",\"optional\":false,\"field\":\"ts_sec\"},{\"type\":\"string\",\"optional\":true,\"field\":\"gtid\"},{\"type\":\"string\",\"optional\":false,\"field\":\"file\"},{\"type\":\"int64\",\"optional\":false,\"field\":\"pos\"},{\"type\":\"int32\",\"optional\":false,\"field\":\"row\"},{\"type\":\"boolean\",\"optional\":true,\"default\":false,\"field\":\"snapshot\"},{\"type\":\"int64\",\"optional\":true,\"field\":\"thread\"},{\"type\":\"string\",\"optional\":true,\"field\":\"db\"},{\"type\":\"string\",\"optional\":true,\"field\":\"table\"}],\"optional\":false,\"name\":\"io.debezium.connector.mysql.Source\",\"field\":\"source\"},{\"type\":\"string\",\"optional\":false,\"field\":\"op\"},{\"type\":\"int64\",\"optional\":true,\"field\":\"ts_ms\"}],\"optional\":false,\"name\":\"ocstore.ocstore.oc_order_product.Envelope\"},\"payload\":{\"before\":null,\"after\":{\"order_product_id\":1,\"order_id\":1,\"product_id\":85,\"name\":\"Гель для посудомоечных машин\",\"model\":\"85-01\",\"quantity\":1,\"price\":\"KEiA\",\"total\":\"KEiA\",\"tax\":\"AA==\",\"reward\":0},\"source\":{\"version\":\"0.7.5\",\"name\":\"ocstore\",\"server_id\":0,\"ts_sec\":0,\"gtid\":null,\"file\":\"mysql-bin.000007\",\"pos\":366885,\"row\":0,\"snapshot\":true,\"thread\":null,\"db\":\"ocstore\",\"table\":\"oc_order_product\"},\"op\":\"c\",\"ts_ms\":1526557456979}}"
        ObjectMapper mapper = new ObjectMapper()
        JsonNode actualObj = mapper.readTree(message)
        String result = JsonPath.read(actualObj.path("payload").toString(), '$.after')
        String result1 = JsonPath.read(message, '$.payload.after')
        println(result1)


        println(result)
    }

}
