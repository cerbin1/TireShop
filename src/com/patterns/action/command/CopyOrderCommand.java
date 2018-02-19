package com.patterns.action.command;

import com.app.model.models.order.Order;
import com.patterns.action.mediator.ApplicationMediator;
import com.patterns.creational.factory.AbstractOrderFactory;

public class CopyOrderCommand implements Command {
    private final Order order;

    public CopyOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void invoke(ApplicationMediator mediator) {
        AbstractOrderFactory factory = order.getFactory();

        Order copyOrder = factory.createOrder();
        mediator.getOrders().add(copyOrder);
    }
}
