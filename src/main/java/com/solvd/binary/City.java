package com.solvd.binary;

public class City {
    private long idCity;
    private String name;
    private Country country;

    public City(long idCity, String name, Country country) {
        this.idCity = idCity;
        this.name = name;
        this.country = country;
    }

    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
