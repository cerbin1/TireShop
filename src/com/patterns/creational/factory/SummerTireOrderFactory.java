package com.patterns.creational.factory;

import com.app.model.models.order.Order;
import com.app.model.models.order.SummerTiresOrder;

public class SummerTireOrderFactory implements AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new SummerTiresOrder();
    }
}
