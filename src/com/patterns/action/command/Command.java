package com.patterns.action.command;

import com.patterns.action.mediator.ApplicationMediator;

public interface Command {
    void invoke(ApplicationMediator mediator);
}
