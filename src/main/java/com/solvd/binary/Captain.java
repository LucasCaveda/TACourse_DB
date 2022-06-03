package com.solvd.binary;

import java.util.Objects;

public class Captain {
    private long id;
    private String name;
    private String lastname;
    private FootballTeam footballTeam;

    public Captain(long id, String name, String lastname, FootballTeam footballTeam) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.footballTeam = footballTeam;
    }

    public Captain() {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public FootballTeam getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeam footballTeam) {
        this.footballTeam = footballTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Captain captain = (Captain) o;
        return id == captain.id && Objects.equals(name, captain.name) && Objects.equals(lastname, captain.lastname) && Objects.equals(footballTeam, captain.footballTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, footballTeam);
    }

    @Override
    public String toString() {
        return "Captain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", footballTeam=" + footballTeam +
                '}';
    }
}
