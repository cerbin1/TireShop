package example;

import com.app.model.models.Client;
import com.app.model.models.order.Order;
import com.app.model.models.order.SummerTiresOrder;
import com.app.model.models.order.TireReplaceOrder;
import com.app.model.models.order.WinterTiresOrder;
import com.patterns.structural.facade.ClientSaveFacade;
import com.patterns.structural.facade.OrderSaveFacade;

import java.util.LinkedList;

public class CreateExampleFiles {
    public static void main(String[] args) {
        ClientSaveFacade.store(getExampleClients());
        OrderSaveFacade.store(getExampleOrders());

        System.out.println("Successfully created example files");
    }

    private static LinkedList<Order> getExampleOrders() {
        LinkedList<Order> orders = new LinkedList<>();

        orders.add(new TireReplaceOrder());
        orders.add(new TireReplaceOrder());
        orders.add(new WinterTiresOrder());
        orders.add(new SummerTiresOrder());
        orders.add(new SummerTiresOrder());
        orders.add(new WinterTiresOrder());
        orders.add(new WinterTiresOrder());

        return orders;
    }

    private static LinkedList<Client> getExampleClients() {
        LinkedList<Client> clients = new LinkedList<>();

        clients.add(new Client("Jan Kowalski", "Poland", "Janex", false));
        clients.add(new Client("Paweł Nowak", "Poland", "Nowakpol", false));
        clients.add(new Client("Katarzyna Wiślicka", "Poland", "Poldex", false));
        clients.add(new Client("Daenerys Targaryen", "Dragonstone", "Dragon Inc.", true));
        clients.add(new Client("Steve Jackson", "United Kingdom", "Comarch", false));
        clients.add(new Client("Jack Stevens", "USA", "None", true));

        return clients;
    }
}
