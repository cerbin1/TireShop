package com.patterns.action.observer;

import com.patterns.action.command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandObservable {
    private final List<CommandObserver> observers = new ArrayList<>();

    public void addCommandObserver(CommandObserver observer) {
        observers.add(observer);
    }

    public void requestCommand(Command command) {
        observers.forEach(observer -> observer.commandRequested(command));
    }
}
