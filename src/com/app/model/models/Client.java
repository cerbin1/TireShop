package com.app.model.models;

import java.io.Serializable;

public class Client implements Serializable {
    private final String name, country, company;
    private final boolean isVip;

    public Client(String name, String country, String company, boolean isVip) {
        this.name = name;
        this.country = country;
        this.company = company;
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public boolean isVip() {
        return isVip;
    }

    @Override
    public String toString() {
        return name + " (" + country + "), " + company + (isVip ? " (VIP)" : "");
    }
}
