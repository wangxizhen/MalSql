package com.data.monkey.grammar.parser.engine.processing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Optional;

@Data
public class SimpleJsonEvent implements ReadableEvent {

    private String json;
    private JSONObject jsonObject;

    public SimpleJsonEvent(String json) {
        this.json = json;
        this.jsonObject = JSON.parseObject(json);
    }

    @Override
    public Optional<Object> readValue(String field) {
        final Object value = jsonObject.getOrDefault(field, null);
        return Optional.ofNullable(value);
    }

    @Override
    public long getTimeStamp() {
        return jsonObject.getLongValue("timestamp");
    }

    @Override
    public String getPartitionKey() {
        // TODO
        return jsonObject.getString("key");
    }
}
