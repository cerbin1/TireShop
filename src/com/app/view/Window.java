package com.app.view;

import com.app.model.models.Client;
import com.app.model.models.order.Order;
import com.patterns.action.command.CopyOrderCommand;
import com.patterns.action.command.NewOrderCommand;
import com.patterns.action.command.UndoOrderCommand;
import com.patterns.action.observer.CommandObservable;
import com.patterns.action.observer.CommandObserver;
import com.patterns.structural.adapter.OrderSelectingKeysAdapter;
import com.patterns.action.mediator.OrderSelector;

import javax.swing.*;
import java.util.List;

import static java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager;
import static javax.swing.SwingUtilities.invokeLater;

public class Window {
    private final ApplicationJFrame frame = new ApplicationJFrame();
    private final CommandObservable observable = new CommandObservable();

    public Window() {
        frame.newButton.addActionListener(action -> observable.requestCommand(new NewOrderCommand()));
        frame.undoButton.addActionListener(action -> observable.requestCommand(new UndoOrderCommand()));

        frame.copyButton.addActionListener(action -> {
            frame.getSelectedOrder().ifPresent(order -> observable.requestCommand(new CopyOrderCommand(order)));
        });
    }

    public void addOrderSelector(OrderSelector orderSelector) {
        getCurrentKeyboardFocusManager().addKeyEventDispatcher(new OrderSelectingKeysAdapter(orderSelector));
    }

    public void addCommandObserver(CommandObserver observer) {
        observable.addCommandObserver(observer);
    }

    public void setClients(List<Client> newClients) {
        DefaultListModel<Client> clients = frame.getClients();

        clients.clear();
        for (Client client : newClients) {
            clients.addElement(client);
        }
    }

    public void setOrders(List<Order> newOrders) {
        DefaultListModel<Order> orders = frame.getOrders();

        orders.clear();
        for (Order order : newOrders) {
            orders.addElement(order);
        }
    }

    public void show() {
        invokeLater(() -> frame.setVisible(true));
    }

    public void setSelectedOrder(int orderIndex) {
        this.frame.setSelectedOrder(orderIndex);
    }
}
