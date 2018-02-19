package com.app.model.models.order;

import com.patterns.creational.factory.AbstractOrderFactory;
import com.patterns.creational.factory.TireReplaceOrderFactory;

public class TireReplaceOrder implements Order {
    @Override
    public AbstractOrderFactory getFactory() {
        return new TireReplaceOrderFactory();
    }

    @Override
    public String toString() {
        return "Tire Replace";
    }
}
