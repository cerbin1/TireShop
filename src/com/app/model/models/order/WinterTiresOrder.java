package com.app.model.models.order;

import com.patterns.creational.factory.AbstractOrderFactory;
import com.patterns.creational.factory.WinterTireOrderFactory;

public class WinterTiresOrder implements Order {
    @Override
    public AbstractOrderFactory getFactory() {
        return new WinterTireOrderFactory();
    }

    @Override
    public String toString() {
        return "Winter Tires";
    }
}
