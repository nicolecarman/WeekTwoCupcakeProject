import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        // requests input from user
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        // user input
        Scanner input = new Scanner(System.in);

        // set user input to variable
        String placeOrder = input.nextLine();

        // create new ArrayList for the user's order
        ArrayList<Object> order = new ArrayList<Object>();



        // checks if user enters Y (ignoring case)
        if (placeOrder.equalsIgnoreCase("Y")) {
            // Add local date and time to the order
            order.add(LocalDate.now());
            order.add(LocalTime.now());

            // output to user
            System.out.println("Here is the menu!");
            System.out.println("CUPCAKES:");


            int itemNumber = 0;


            // iterate through cupcake menu
            for (int i = 0; i < cupcakeMenu.size(); i++) {
                // increment by one
                itemNumber++;

                // output to user that prints item number, description, and price
                System.out.print(itemNumber + ". ");

                cupcakeMenu.get(i).type();

                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());

                // print new line
                System.out.println();
            }


            // iterate through drink menu
            System.out.println("DRINKS:");

            for (int i = 0; i < drinkMenu.size(); i++) {
                // increment by one
                itemNumber++;

                // output to user that prints item number, description, and price
                System.out.print(itemNumber + ". ");

                drinkMenu.get(i).type();

                System.out.println("Price: $" + drinkMenu.get(i).getPrice());

                // print new line
                System.out.println();
            }
        }
        else {
            // prints if user enters anything but Y
            System.out.println("Have a nice day then.");
        }



        boolean ordering = true;

        // continues as long as ordering = true
        while (ordering) {
            // output to user
            System.out.println("What would you like to order? Please use the number associated with each item to order");

            // set user input to variable
            int orderChoice = input.nextInt();

            // scanner location
            input.nextLine();



            // handles user's order choice
            if (orderChoice == 1) {
                // adds 1st item from cupcakeMenu to order array and provides user input
                order.add(cupcakeMenu.get(0));

                System.out.println("Item added to order!");
            }
            else if (orderChoice == 2) {
                // adds 2nd item from cupcakeMenu to order array and provides user input
                order.add(cupcakeMenu.get(1));

                System.out.println("Item added to order!");
            }
            else if (orderChoice == 3) {
                // adds 3rd item from cupcakeMenu to order array and provides user input
                order.add(cupcakeMenu.get(2));

                System.out.println("Item added to order!");
            }
            else if (orderChoice == 4) {
                // adds 1st item from drinkMenu to order array and provides user input
                order.add(drinkMenu.get(0));

                System.out.println("Item added to order!");
            }
            else if (orderChoice == 5) {
                // adds 2nd item from drinkMenu to order array and provides user input
                order.add(drinkMenu.get(1));

                System.out.println("Item added to order!");
            }
            else if (orderChoice == 6) {
                // adds 3rd item from drinkMenu to order array and provides user input
                order.add(drinkMenu.get(2));

                System.out.println("Item added to order!");
            }
            else {
                // prints if user enters a number that doesn't correspond to a menu item
                System.out.println("Sorry, we don't seem to have that on the menu");
            }



            // asks for user input
            System.out.println("Would you like to continue ordering? (Y/N)");

            // set user input to variable
            String continueOrder = input.nextLine();

            // checks if user is done ordering (ignoring case)
            if (!continueOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }



        // GENERATE RECEIPT FOR ORDER
        // output to user
        System.out.println(order.get(0));
        System.out.println(order.get(1));

        Double subTotal = 0.0;

        // iterates through order array and checks if each menu item is in array
        for (int i = 2; i < order.size(); i++) {
            if (order.get(i).equals(cupcakeMenu.get(0))) {
                // output to user (type and price)
                cupcakeMenu.get(0).type();

                System.out.println(cupcakeMenu.get(0).getPrice());

                subTotal = subTotal + cupcakeMenu.get(0).getPrice();
            }
            else if (order.get(i).equals(cupcakeMenu.get(1))) {
                // output to user (type and price)
                cupcakeMenu.get(1).type();

                System.out.println(cupcakeMenu.get(1).getPrice());

                subTotal = subTotal + cupcakeMenu.get(1).getPrice();
            }
            else if (order.get(i).equals(cupcakeMenu.get(2))) {
                // output to user (type and price)
                cupcakeMenu.get(2).type();

                System.out.println(cupcakeMenu.get(2).getPrice());

                subTotal = subTotal + cupcakeMenu.get(2).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(0))) {
                // output to user (type and price)
                drinkMenu.get(0).type();

                System.out.println(drinkMenu.get(0).getPrice());

                subTotal = subTotal + drinkMenu.get(0).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(1))) {
                // output to user (type and price)
                drinkMenu.get(1).type();

                System.out.println(drinkMenu.get(1).getPrice());

                subTotal = subTotal + drinkMenu.get(1).getPrice();
            }
            else if (order.get(i).equals(drinkMenu.get(2))) {
                // output to user (type and price)
                drinkMenu.get(2).type();

                System.out.println(drinkMenu.get(2).getPrice());

                subTotal = subTotal + drinkMenu.get(2).getPrice();
            }
        }

        // outputs to user (subtotal)
        System.out.println("$" + subTotal + "\n");



        // creates new CreateFile()
        new CreateFile();


        // creates new WriteToFile() with the user's order as parameter
        new WriteToFile(order);
    }
}




// IO EXCEPTION
class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");

            // will return true if a new file is created
            if (salesData.createNewFile()) {
                // output to user
                System.out.println("File created: " + salesData.getName());
            }
            else {
                // outputs if file already exists
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            // outputs if there's an IO exception
            System.out.println("An error occurred");
        }
    }
}




// WRITE TO FILE
class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            // allows for appending to file
            FileWriter fw = new FileWriter("salesData.txt", true);

            PrintWriter salesWriter = new PrintWriter(fw);


            //  print values in order
            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }


            // close to prevent it from continuing to run
            salesWriter.close();


            // output to user
            System.out.println("Successfully wrote to the file");
        }
        catch (IOException e) {
            // outputs if there's an IO exception
            System.out.println("An error occurred");
        }
    }
}