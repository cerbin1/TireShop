package com.patterns.action.observer;

import com.patterns.action.command.Command;

public interface CommandObserver {
    void commandRequested(Command command);
}
