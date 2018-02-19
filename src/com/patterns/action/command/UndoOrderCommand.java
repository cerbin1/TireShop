package com.patterns.action.command;

import com.app.model.models.order.Order;
import com.patterns.action.mediator.ApplicationMediator;

import java.util.List;

public class UndoOrderCommand implements Command {
    @Override
    public void invoke(ApplicationMediator mediator) {
        List<Order> orders = mediator.getOrders();

        if (orders.isEmpty()) return;

        int size = orders.size();
        orders.remove(size - 1);
    }
}
