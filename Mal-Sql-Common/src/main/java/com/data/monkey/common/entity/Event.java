package com.data.monkey.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Data
public class Event implements Serializable {
    private static final long serialVersionUID = -963998283053552683L;
    private Map<String, String> metrics;
    private long timestamp;
    private String key;



    public Event(String key, Map<String, String> metrics) {
        this.key = key;
        this.metrics = metrics;
        timestamp = System.currentTimeMillis();
    }

    public Event() {
        metrics = new HashMap<String, String>();
        timestamp = System.currentTimeMillis();
    }

    public Event(String key, Map<String, String> metrics, long timestamp) {
        this.key = key;
        this.metrics = metrics;
        this.timestamp = timestamp;
    }


    public Event(String key, Map<String, String> metrics, UUID uuid, long timestamp, long timeScope, long time) {
        this.key = key;
        this.metrics = metrics;
        this.timestamp = timestamp;
    }

}
