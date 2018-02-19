package com.patterns.structural.adapter;

import com.patterns.action.mediator.OrderSelector;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class OrderSelectingKeysAdapter implements KeyEventDispatcher {
    private final OrderSelector selector;

    public OrderSelectingKeysAdapter(OrderSelector selector) {
        this.selector = selector;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        eventPressedReceived(event);
        if (event.getID() == KEY_PRESSED) {
        }

        event.consume();
        return true;
    }

    private void eventPressedReceived(KeyEvent event) {
        if (event.isControlDown()) {
            keyPressedWithCtrl(event.getKeyCode());
        } else {
            keyPressed(event.getKeyCode());
        }
    }

    private void keyPressedWithCtrl(int keyCode) {
        if (keyCode == VK_UP) selector.firstOrder();
        if (keyCode == VK_DOWN) selector.lastOrder();
    }

    private void keyPressed(int keyCode) {
        if (keyCode == VK_UP) selector.previousOrder();
        if (keyCode == VK_DOWN) selector.nextOrder();

        if (keyCode >= VK_0 && keyCode <= VK_9) {
            int digit = keyCode - VK_0;
            selector.orderByIndex(digit - 1);
        }
    }
}
