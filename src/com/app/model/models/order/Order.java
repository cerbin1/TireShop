package com.app.model.models.order;

import com.patterns.creational.factory.AbstractOrderFactory;

import java.io.Serializable;

public interface Order extends Serializable {
    AbstractOrderFactory getFactory();
}
