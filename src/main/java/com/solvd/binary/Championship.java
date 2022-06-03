package com.solvd.binary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "championship")

public class Championship {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty("football league")
    private FootballLeague footballLeague;

    public Championship(long id, String name, FootballLeague footballLeague) {
        this.id = id;
        this.name = name;
        this.footballLeague = footballLeague;
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

    public FootballLeague getFootballLigue() {
        return footballLeague;
    }

    public void setFootballLigue(FootballLeague footballLeague) {
        this.footballLeague = footballLeague;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", footballLeague=" + footballLeague +
                '}';
    }
}
