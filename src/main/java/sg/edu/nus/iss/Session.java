package sg.edu.nus.iss;

import java.io.Console;
import java.io.IOException;
import java.util.List;

public class Session {

    private ShoppingCartDB repository;
    private ShoppingCart currentCart;

    private static final String END = "end";
    private static final String ADD = "add";
    private static final String LIST = "list";
    private static final String USERS = "users";
    private static final String LOGIN = "login";
    private static final String SAVE = "save";

    public Session(ShoppingCartDB repository) {
        this.repository = repository;
    }

    public void start() {
        Console console = System.console();

        boolean stop = false;

        System.out.println("Welcome to your shopping cart");

        while (!stop) {

            String input = console.readLine("> ");
            String[] term = input.split(" ");
            switch (term[0]) {
                case END:
                    stop = true;
                    System.out.println("Thank you!");
                    break;
                case ADD:
                    for (int i = 1; i < term.length; i++) {
                        try {
                            currentCart.add(term[i]);
                            System.out.println(term[i] + " added to the cart");
                            // System.out.println(ShoppingCart.getItemList());
                            // System.out.println(ShoppingCart.getItemList().size());
                        } catch (NullPointerException e) {
                            System.out.println("Please login before adding items to the cart!");
                        }
                    }
                    break;

                case LIST: // unable to list without save? overwrite!!!
                    currentCart = repository.load(currentCart.getName());
                    printAllItems(currentCart.getItemList());
                    break;

                case USERS:
                    List<String> users = repository.listUsers();
                    System.out.println("The following users are registered: ");
                    int count = 1;
                    for (String user : users) {
                        // for (int i = 1; i < users.size(); i++) {
                        System.out.println(count + ". " + user);
                        count++;
                        // }
                    }
                    break;
                case LOGIN: // need help..
                    // if (currentCart.getName() == term[1]) {
                    // if (currentCart.getItemList() == null) {
                    // System.out.println(term[1] + ", your card is empty..");
                    // } else {
                    // System.out.println(term[1] + ", your card contains the following items:");
                    // printAllItems(currentCart.getItemList());
                    // }
                    // } else {
                    currentCart = new ShoppingCart(term[1]);
                    // }
                    break;
                case SAVE:
                    try {
                        repository.save(currentCart);
                        System.out.println("Your cart has been saved");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }

    }

    public void printAllItems(List<String> items) {
        if (items.size() == 0) {
            System.out.println("No items in the cart..");
            return;
        }

        for (String item : items) {
            System.out.printf("%d %s.\n", (items.indexOf(item) + 1), item);
        }

    }

}
