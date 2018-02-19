package com.patterns.action.mediator;

public interface OrderSelector {
    void firstOrder();

    void previousOrder();

    void orderByIndex(int index);

    void nextOrder();

    void lastOrder();
}
