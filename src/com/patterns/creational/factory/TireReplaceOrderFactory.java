package com.patterns.creational.factory;

import com.app.model.models.order.Order;
import com.app.model.models.order.TireReplaceOrder;

public class TireReplaceOrderFactory implements AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new TireReplaceOrder();
    }
}
