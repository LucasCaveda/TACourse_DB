package com.solvd.binary;

public class Partner {
    private long id;
    private String brandName;
    private FootballTeam footballTeam;

    public Partner(long id, String brandName, FootballTeam footballTeam) {
        this.id = id;
        this.brandName = brandName;
        this.footballTeam = footballTeam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public FootballTeam getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeam footballTeam) {
        this.footballTeam = footballTeam;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", footballTeam=" + footballTeam +
                '}';
    }
}

