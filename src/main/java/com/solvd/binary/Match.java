package com.solvd.binary;

import java.util.Date;

public class Match {
    private long id;
    private int qGoals;
    private String result;
    private Date date;
    private Championship championship;
    private Stadium stadium;
    private FootballTeam FootballTeam1;
    private FootballTeam FootballTeam2;

    public Match() {
    }

    public Match(long id, int qGoals, String result, Date date, Championship championship, Stadium stadium, FootballTeam footballTeam1, FootballTeam footballTeam2, TecnichalManager technicalManager) {
        this.id = id;
        this.qGoals = qGoals;
        this.result = result;
        this.date = date;
        this.championship = championship;
        this.stadium = stadium;
        FootballTeam1 = footballTeam1;
        FootballTeam2 = footballTeam2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getqGoals() {
        return qGoals;
    }

    public void setqGoals(int qGoals) {
        this.qGoals = qGoals;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public FootballTeam getFootballTeam1() {
        return FootballTeam1;
    }

    public void setFootballTeam1(FootballTeam footballTeam1) {
        FootballTeam1 = footballTeam1;
    }

    public FootballTeam getFootballTeam2() {
        return FootballTeam2;
    }

    public void setFootballTeam2(FootballTeam footballTeam2) {
        FootballTeam2 = footballTeam2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", qGoals=" + qGoals +
                ", result='" + result + '\'' +
                ", date=" + date +
                ", championship=" + championship +
                ", stadium=" + stadium +
                ", FootballTeam1=" + FootballTeam1 +
                ", FootballTeam2=" + FootballTeam2 +
                '}';
    }
}
