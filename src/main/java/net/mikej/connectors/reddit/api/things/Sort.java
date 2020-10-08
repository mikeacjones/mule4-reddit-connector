package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sort {
    CONFIDENCE("confidence"),
    TOP("top"),
    NEW("new"),
    CONTROVERSIAL("controversial"),
    OLD("old"),
    RANDOM("random"),
    QA("qa"),
    LIVE("live");

    private final String sortValue;
    private Sort(String sortValue) {
        this.sortValue = sortValue;
    }
    @JsonValue
    public String getSortvalue() { return sortValue; }
}
