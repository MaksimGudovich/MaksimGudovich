package com.epam.tc.hw9api.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardTrello {

    private String id;
    private String name = "Default Test Board Name";

    public String getId() {
        return id;
    }

    public BoardTrello setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BoardTrello setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Board{"
            + "id='" + id + '\''
            + ", name='" + name + '\''
            + '}';
    }
}
