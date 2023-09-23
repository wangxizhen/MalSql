package com.data.monkey.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Map;


@Data
@EqualsAndHashCode
public class Event implements Serializable {
    private static final long serialVersionUID = -963998283053552683L;
    private static final int HOUR = 1000 * 60 * 60;
    private static final int MIN = 1000 * 60;
    private Map<String, String> metrics;
    private long timestamp;
    private String key;

    private Map<String, String> tags;

    private Long index;

    private String RuleId;




}