package com.solvd.binary;

public class Owner {
    private long id;
    private String name;
    private String lastname;
    private FootballTeam footballTeam;

    public Owner(long id, String name, String lastname, FootballTeam footballTeam) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.footballTeam = footballTeam;
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

    public void setFootballTeam(FootballTeam footballTeamId) {
        this.footballTeam = footballTeamId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", footballTeamId=" + footballTeam +
                '}';
    }
}
