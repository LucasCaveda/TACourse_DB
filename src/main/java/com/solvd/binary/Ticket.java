package com.solvd.binary;

import java.util.Date;

public class Ticket {
    private long id;
    private Date date;
    private int ubication;
    private Stadium stadium;

    public Ticket(long id, Date date, int ubication, Stadium stadium) {
        this.id = id;
        this.date = date;
        this.ubication = ubication;
        this.stadium = stadium;
    }

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUbication() {
        return ubication;
    }

    public void setUbication(int ubication) {
        this.ubication = ubication;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", ubication=" + ubication +
                ", stadium=" + stadium +
                '}';
    }
}
