package com.patterns.creational.builder;

import com.app.model.models.Client;

public class ClientBuilder {
    private String name, country, company;
    private Boolean isVip;

    public ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public ClientBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public ClientBuilder setVip(Boolean vip) {
        isVip = vip;
        return this;
    }

    public Client create() {
        return new Client(name, country, company, isVip);
    }
}
