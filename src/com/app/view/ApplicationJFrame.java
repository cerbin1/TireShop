package com.app.view;

import com.app.model.models.Client;
import com.app.model.models.order.Order;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Optional;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.Color.white;
import static java.awt.FlowLayout.LEFT;

class ApplicationJFrame extends JFrame {
    private final DefaultListModel<Order> orders = new DefaultListModel<>();
    private final DefaultListModel<Client> clients = new DefaultListModel<>();

    private final JList<Order> ordersList = new JList<>(this.orders);

    public final JButton copyButton = new JButton("Copy");
    public final JButton newButton = new JButton("New");
    public final JButton undoButton = new JButton("Undo");

    ApplicationJFrame() {
        initializeGUI();
    }

    public DefaultListModel<Order> getOrders() {
        return orders;
    }

    public DefaultListModel<Client> getClients() {
        return clients;
    }

    public Optional<Order> getSelectedOrder() {
        return Optional.ofNullable(ordersList.getSelectedValue());
    }

    public void setSelectedOrder(int index) {
        ordersList.setSelectedIndex(index);
    }

    private void initializeGUI() {
        setTitle("Wzorce Projektowe | Sklep z oponami");
        setMinimumSize(new Dimension(650, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(white);
        setLayout(new BorderLayout(0, 20));
        add(getOrdersPanel(), NORTH);
        add(withScrollAndTitle(new JList<>(clients), "Clients"), CENTER);
    }

    private JPanel getOrdersPanel() {
        JPanel ordersPanel = new JPanel(new BorderLayout());
        ordersPanel.setBackground(white);
        ordersPanel.setBorder(new TitledBorder("Order commands"));
        ordersList.setFocusable(false);
        ordersPanel.add(withScrollAndTitle(ordersList, "Orders"), CENTER);
        ordersPanel.add(createOrdersToolbar(), NORTH);
        return ordersPanel;
    }

    private <T> JScrollPane withScrollAndTitle(JList<T> list, String title) {
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setBorder(new TitledBorder(title));
        jScrollPane.setBackground(white);

        return jScrollPane;
    }

    private JPanel createOrdersToolbar() {
        JPanel toolbar = new JPanel(new FlowLayout(LEFT));
        toolbar.add(copyButton);
        toolbar.add(newButton);
        toolbar.add(undoButton);
        toolbar.setBackground(white);
        return toolbar;
    }
}
