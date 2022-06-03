package com.solvd.binary;

import java.util.List;
import java.util.Objects;

public class FootballTeam {
    private long id;
    private String name;
    private TecnichalManager technicalManager;
    private Stadium stadium;
    private President president;
    private City city;
    private List<Player> players;

    public FootballTeam() {
    }

    public FootballTeam(long id, String name, TecnichalManager technicalManager, Stadium stadium, President president, City city, List<Player> players) {
        this.id = id;
        this.name = name;
        this.technicalManager = technicalManager;
        this.stadium = stadium;
        this.president = president;
        this.city = city;
        this.players = players;
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

    public TecnichalManager getTechnicalManager() {
        return technicalManager;
    }

    public void setTechnicalManager(TecnichalManager technicalManager) {
        this.technicalManager = technicalManager;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public President getPresident() {
        return president;
    }

    public void setPresident(President president) {
        this.president = president;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technicalManager=" + technicalManager +
                ", stadium=" + stadium +
                ", president=" + president +
                ", city=" + city +
                ", players=" + players +
                '}';
    }
}

