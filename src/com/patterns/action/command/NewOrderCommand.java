package com.patterns.action.command;

import com.app.model.models.order.Order;
import com.patterns.action.mediator.ApplicationMediator;
import com.patterns.creational.factory.OrderFactory;

import static javax.swing.JOptionPane.*;

public class NewOrderCommand implements Command {
    private final OrderFactory factory = new OrderFactory();

    @Override
    public void invoke(ApplicationMediator mediator) {
        String[] options = getOptions();

        int result = showOptionDialog(null, "Chose order:", "New Order", DEFAULT_OPTION, QUESTION_MESSAGE, null, options, null);

        if (result > DEFAULT_OPTION) {
            addOrder(mediator, options[result]);
        }
    }

    private void addOrder(ApplicationMediator mediator, String selectedOption) {
        Order newOrder = factory.createFromString(selectedOption);

        mediator.addOrder(newOrder);
    }

    private String[] getOptions() {
        return factory.orders().toArray(new String[0]);
    }
}
