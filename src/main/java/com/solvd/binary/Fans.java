package com.solvd.binary;

public class Fans {
    private long id;
    private String name;
    private String lastname;
    private Ticket ticket;

    public Fans(long id, String name, String lastname, Ticket ticket) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.ticket = ticket;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
