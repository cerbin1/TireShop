package com.patterns.creational.factory;

import com.app.model.models.order.Order;
import com.app.model.models.order.WinterTiresOrder;

public class WinterTireOrderFactory implements AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new WinterTiresOrder();
    }
}
