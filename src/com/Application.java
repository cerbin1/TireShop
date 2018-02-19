package com;

import com.patterns.action.mediator.ApplicationMediator;
import com.app.view.Window;

public class Application {
    public static void main(String[] args) {
        new ApplicationMediator(new Window()).startApplication();
    }
}
