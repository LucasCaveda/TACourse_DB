package com.solvd.binary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FootballLeague {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String category;

    public FootballLeague(long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FootballLeague{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
