package com.patterns.structural.facade;

import com.app.model.files.FileStore;
import com.app.model.models.order.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderSaveFacade {
    private final static String filename = "orders.dat";

    public static void store(List<Order> clients) {
        try {
            new FileStore(filename).store(new ArrayList<>(clients));
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static List<Order> read() {
        try {
            return new FileStore(filename)
                    .read()
                    .stream()
                    .map(Order.class::cast)
                    .collect(toList());
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
