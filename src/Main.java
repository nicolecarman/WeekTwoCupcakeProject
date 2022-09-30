import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // CUPCAKES
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        // cupcake objects
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        // output to user
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on" +
                "\nthe menu but we need to decide on pricing.");

        // user input
        Scanner input = new Scanner(System.in);



        // STANDARD CUPCAKE
        // output to user
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description: ");

        // get the description of the regular cupcake
        cupcake.type();

        // output to user
        System.out.println("How much would you like to charge for the cupcake?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        String priceText = input.nextLine();

        double price = Double.parseDouble(priceText);

        // call setPrice() with the entered cupcake price
        cupcake.setPrice(price);



        // RED VELVET CUPCAKE
        // output to user
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description: ");

        // get the description of the red velvet cupcake
        redVelvet.type();

        // output to user
        System.out.println("How much would you like to charge for the cupcake?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        priceText = input.nextLine();

        price = Double.parseDouble(priceText);

        // call setPrice() with the entered cupcake price
        redVelvet.setPrice(price);



        // CHOCOLATE CUPCAKE
        // output to user
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description: ");

        // get the description of the chocolate cupcake
        chocolate.type();

        // output to user
        System.out.println("How much would you like to charge for the cupcake?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        priceText = input.nextLine();

        price = Double.parseDouble(priceText);

        // call setPrice() with the entered cupcake price
        chocolate.setPrice(price);



        // Add cupcakes to the menu
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);




        // DRINKS
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();

        // drink objects
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        // output to user
        System.out.println("We are in the middle of creating the drink menu. We currently have three types of drinks on" +
                "\nthe menu but we need to decide on pricing.");

        // note on scanner object: we don't need to put another one here. we're using the other one!



        // WATER
        // output to user
        System.out.println("We are deciding on the price for our bottled water. Here is the description: ");

        // get the description of the water
        water.type();

        // output to user
        System.out.println("How much would you like to charge for the water bottle?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        priceText = input.nextLine();

        price = Double.parseDouble(priceText);

        // call setPrice() with the entered drink price
        water.setPrice(price);



        // SODA
        // output to user
        System.out.println("We are deciding on the price for our bottle of soda. Here is the description: ");

        // get the description of the soda
        soda.type();

        // output to user
        System.out.println("How much would you like to charge for the bottled soda?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        priceText = input.nextLine();

        price = Double.parseDouble(priceText);

        // call setPrice() with the entered drink price
        soda.setPrice(price);



        // MILK
        // output to user
        System.out.println("We are deciding on the price for our bottle of milk. Here is the description: ");

        // get the description of the milk
        milk.type();

        // output to user
        System.out.println("How much would you like to charge for the bottled milk?" +
                "\n(Input a numerical number taken to 2 decimal places.)");

        priceText = input.nextLine();

        price = Double.parseDouble(priceText);

        // call setPrice() with the entered drink price
        milk.setPrice(price);



        // add drinks to drinkMenu
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);



        // call Order constructor and pass in cupcakeMenu and drinkMenu
        new Order(cupcakeMenu, drinkMenu);
    }
}



// All cupcakes will inherit from this class
class Cupcake {
    public double price;


    // returns cupcake price
    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    // prints description of cupcake
    public void type() {
        System.out.println("A basic, generic cupcake with vanilla frosting.");
    }
}



// Red Velvet cupcake
class RedVelvet extends Cupcake {
    // prints description of cupcake
    public void type() {
        System.out.println("A red velvet-based cupcake with cream cheese frosting.");
    }
}



// Chocolate cupcake
class Chocolate extends Cupcake {
    // prints description of cupcake
    public void type() {
        System.out.println("A chocolate-based cupcake with chocolate frosting.");
    }
}



// All drinks will inherit from this class
class Drink {
    public double price;

    // returns drink price
    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    // prints description of drink
    public void type() {
        System.out.println("A bottle of water.");
    }
}



// Soda
class Soda extends Drink {
    // prints description of drink
    public void type() {
        System.out.println("A bottle of soda.");
    }
}



// Milk
class Milk extends Drink {
    // prints description of drink
    public void type() {
        System.out.println("A bottle of milk.");
    }
}