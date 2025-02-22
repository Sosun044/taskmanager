package com.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatus {
    @JsonProperty("To Do")
    TO_DO("To Do"),
    @JsonProperty("Canceled")
    CANCELED("Canceled"),
    @JsonProperty("Done")
    DONE("Done"),
    @JsonProperty("In Progress")
    IN_PROGRESS("In Progress");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaskStatus fromString(String value) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.value.equalsIgnoreCase(value) || status.name().replace("_", " ").equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus: " + value);
    }



}
