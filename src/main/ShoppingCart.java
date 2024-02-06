package main;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart! :>");
    
        List<String> myCart = new ArrayList<String>();

        Console console = System.console();
        String input = "";
        input = input.toLowerCase();
        
        while(!input.equals("quit")) {
            input = console.readLine(">");
            
            if (input.equals("list")) {

                if (myCart.size() > 0) { 
                    
                    for (int i = 0; i < myCart.size(); i++) {
                        
                        System.out.printf("%d. %s\n", (i+1), myCart.get(i));
                    }
                } else {
                    System.out.printf("Your cart is empty!");
                }
            }

            //input.trim();
            if (input.startsWith("add")) {
                input = input.replace(",", " ");

                Scanner scan = new Scanner(input.substring(4));
                String data = "";
                
                while(scan.hasNext()) { 
                    data = scan.next();
                    myCart.add(data);
                    System.out.println(data + "added to cart");
                }
                scan.close();
            }

            if (input.startsWith("delete")) {

                Scanner scan = new Scanner(input.substring(6));
                //int index = Integer.parseInt("");
                // index = index - 1;
                String val = "";
                
                while(scan.hasNext()) { 
                     val = scan.next();

                    int index = Integer.parseInt(val);
                    index = index - 1;

                    if (index < myCart.size()) {
                        myCart.remove(index);
                        //System.out.println( + "added to cart");
                    } else {
                        System.err.println("Incorrect item index ");
                    }
                }
             scan.close();

            }

            if (input.startsWith("save")) {
            
                
            }
        }

        System.out.println("Goodbye! See you next time! :>");
        
    
    }
}
