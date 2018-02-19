package com.patterns.action.mediator;

import com.app.model.models.Client;
import com.app.model.models.order.Order;
import com.app.view.Window;
import com.patterns.action.command.Command;
import com.patterns.action.observer.CommandObserver;
import com.patterns.structural.facade.ClientSaveFacade;
import com.patterns.structural.facade.OrderSaveFacade;

import java.util.List;

import static java.lang.Math.min;

public class ApplicationMediator implements OrderSelector, CommandObserver {
    private final Window window;
    private final List<Order> orders;
    private final List<Client> clients;

    private int selectedOrder = 0;

    public ApplicationMediator(Window window) {
        this.window = window;
        this.clients = ClientSaveFacade.read();
        this.orders = OrderSaveFacade.read();

        resetWindowData();

        this.window.addCommandObserver(this);
        this.window.addOrderSelector(this);
    }

    public void startApplication() {
        window.show();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void commandRequested(Command command) {
        command.invoke(this);
        resetWindowData();
    }

    private void resetWindowData() {
        window.setClients(this.clients);
        window.setOrders(this.orders);
    }

    @Override
    public void firstOrder() {
        selectOrder(0);
    }

    @Override
    public void previousOrder() {
        selectOrder(selectedOrder - 1);
    }

    @Override
    public void orderByIndex(int index) {
        selectOrder(index);
    }

    @Override
    public void nextOrder() {
        selectOrder(selectedOrder + 1);
    }

    @Override
    public void lastOrder() {
        selectOrder(orders.size() - 1);
    }

    private void selectOrder(int index) {
        selectedOrder = getSelectedOrder(index);
        window.setSelectedOrder(selectedOrder);
    }

    private int getSelectedOrder(int index) {
        if (orders.isEmpty()) {
            return -1;
        }

        if (index < 0) {
            return 0;
        }

        return min(index, orders.size() - 1);
    }
}
