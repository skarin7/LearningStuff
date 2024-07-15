package com.practice;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.LongNode;

import java.io.IOException;

public class DateToTimestampDeserializer extends JsonDeserializer<Long> {


    @Override
    public Long deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
        JsonNode node = jp.readValueAsTree();
        return node instanceof LongNode ? node.asLong():  node.get("$date").asLong();
    }
}
