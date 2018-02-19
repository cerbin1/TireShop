package com.patterns.creational.factory;

import com.app.model.models.order.Order;

import java.util.HashMap;
import java.util.Set;

public class OrderFactory {
    private HashMap<String, AbstractOrderFactory> factories = new HashMap<String, AbstractOrderFactory>() {{
        put("summer tires", new SummerTireOrderFactory());
        put("winter tires", new WinterTireOrderFactory());
        put("replace tires", new TireReplaceOrderFactory());
    }};

    public Order createFromString(String name) {
        return factories.get(name).createOrder();
    }

    public Set<String> orders() {
        return factories.keySet();
    }
}
