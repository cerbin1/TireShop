package com.app.model.models.order;

import com.patterns.creational.factory.AbstractOrderFactory;
import com.patterns.creational.factory.SummerTireOrderFactory;

public class SummerTiresOrder implements Order {
    @Override
    public AbstractOrderFactory getFactory() {
        return new SummerTireOrderFactory();
    }

    @Override
    public String toString() {
        return "Summer Tires";
    }
}
