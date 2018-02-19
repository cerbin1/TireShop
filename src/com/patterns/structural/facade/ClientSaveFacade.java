package com.patterns.structural.facade;

import com.app.model.files.FileStore;
import com.app.model.models.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ClientSaveFacade {
    private static final String filename = "clients.dat";

    public static void store(List<Client> clients) {
        try {
            new FileStore(filename).store(new ArrayList<>(clients));
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static List<Client> read() {
        try {
            return new FileStore(filename)
                    .read()
                    .stream()
                    .map(Client.class::cast)
                    .collect(toList());
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
