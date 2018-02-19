package com.patterns.creational.factory;

import com.app.model.models.order.Order;

public interface AbstractOrderFactory {
    Order createOrder();
}
