package com.codewithyen;

import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {
        //Scanner method
        Scanner scanner = new Scanner(System.in);
        //Declare the necessary variables
        String name;
        String date;

        System.out.println("Welcome to the Shopping Cart App.\n");
        //Print the statement
        System.out.println("Enter Customer's Name: ");

        //Get the name from the user
        name = scanner.nextLine();

        //Print the statement
        System.out.println("Enter Today's Date: ");

        //Get the date from the user
        date = scanner.nextLine();

        //Create object for the class "ShoppingCart"
        ShoppingCart shoppingCart = new ShoppingCart(name,date);

        //Print the customer name
        System.out.println("\nCustomer's Name: " + shoppingCart.getCustomerName());

        //Print the date
        System.out.println("Today's Date: " + shoppingCart.getDate() + "\n");

        //Call the function "printMenu()"
        printMenu(shoppingCart, scanner);

        //Exit
        System.exit(0);

    }

    //Define the function "printMenu()"
    public static void printMenu(ShoppingCart shoppingCart, Scanner scanner){
        //Declare the necessary variables
        char ch;
        boolean done = false;

        //Print the menu
        String menu = ("\t\t\tMENU "
                + "\na - Add item to cart "
                + "\nd - Remove item from cart "
                + "\nc - Change item quantity "
                + "\ni - Output items' descriptions "
                + "\no - Output shopping cart "
                + "\nq - Quit ");
        System.out.print(menu);

        //do loop
        do{
            //Print the statement
            System.out.print(" \nChoose an option: ");

            //Get the option from the user
            ch = scanner.next().charAt(0);

            //Switch case
            switch (ch){
                //Case "q" to quit the program
                case ('q'):
                    System.out.println();
                    //Assign "true" to done
                    done = true;
                    break;

                    //Case "o" to output shopping cart
                case ('o'):
                    //Print the statement
                    System.out.println("\n\tOUTPUT SHOPPING CART");
                    //Print the shopping cart
                    System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate());
                    //Check item in a cart is equal to zero
                    if(shoppingCart.getNumItemsInCart() == 0){
                        //True, Print cart is empty
                        System.out.print("SHOPPING CART IS EMPTY");
                    }

                    //Otherwise
                    else
                        //Print the number of items
                        System.out.println("Number of Items: " + shoppingCart.getNumItemsInCart());

                    //Call the method "printTotal()"
                    shoppingCart.printTotal();
                    //Print the total
                    System.out.println("Total: $" + shoppingCart.getCostOfCart());
                    //Print the menu
                    System.out.print("\n" + menu);
                    //Break statement
                    break;

                    //Case "i" to output items' description
                case ('i'):
                    if(shoppingCart.getNumItemsInCart() == 0){
                        //True, Print cart is empty
                        System.out.print("SHOPPING CART IS EMPTY");
                    }
                    else {
                        //Print the statement
                        System.out.println("\n\tOUTPUT ITEMS' DESCRIPTIONS");
                        //Print the shopping cart
                        System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate() + " ");
                        //Call the method "printDescriptions()"
                        shoppingCart.printDescriptions();
                        //Print the menu
                        System.out.print("\n" + menu);
                    }
                    break;

                //Case "a" to add item to the cart
                case ('a'):
                    //Create object for the class "ItemToPurchase()"
                    ItemToPurchase itemToPurchase = new ItemToPurchase();
                    //Print the statement
                    scanner.nextLine();
                    System.out.println("\n\tADD ITEM TO CART");
                    System.out.print("Enter the item name: ");
                    //Get the item name from the user
                    itemToPurchase.setItemName(scanner.nextLine());
                    //Print the statement
                    System.out.print("Enter the item description: ");
                    //Get the item description from the user
                    itemToPurchase.setDescription(scanner.nextLine());
                    //Print the statement
                    System.out.print("Enter the item price: ");
                    //Get the item price from the user
                    itemToPurchase.setItemPrice(scanner.nextInt());
                    //Print the statement
                    System.out.print("Enter the item quantity: ");
                    //Get item quantity from the user
                    itemToPurchase.setItemQuantity(scanner.nextInt());
                    //Call the function "addItem()"
                    shoppingCart.addItem(itemToPurchase);
                    //Print the menu
                    System.out.print(" \n" + menu);
                    break;

                    //Case "d" to remove item from the cart
                case ('d'):
                    if(shoppingCart.getNumItemsInCart() == 0){
                        //True, Print cart is empty
                        System.out.print("SHOPPING CART IS EMPTY" );
                    }
                    else {
                        scanner.nextLine();
                        System.out.println("\tREMOVE ITEM FROM CART");
                        System.out.print("Enter name of item to remove: ");
                        //Get the item name from the user
                        shoppingCart.removeItem(scanner.nextLine());
                        //Print the menu
                        System.out.print(" \n" + menu);
                    }
                    break;

                //Case "c" to change item quantity
                case ('c'):
                    if(shoppingCart.getNumItemsInCart() == 0){
                        //True, Print cart is empty
                        System.out.print("SHOPPING CART IS EMPTY" );
                    }
                    else {
                        //Print the statement
                        System.out.println("\n\tCHANGE ITEM QUANTITY");
                        //Create object for the class "ItemToPurchase"
                        ItemToPurchase itemToPurchase1 = new ItemToPurchase();
                        //Print the statement
                        scanner.nextLine();
                        System.out.print("Enter the item name: ");
                        //Get the item name from the user
                        itemToPurchase1.setItemName(scanner.nextLine());
                        //Print the statement
                        System.out.print("Enter the new quantity: ");
                        //Get the quantity from the user
                        itemToPurchase1.setItemQuantity(scanner.nextInt());
                        //Call the function "modifyItem()"
                        shoppingCart.modifyItem(itemToPurchase1);
                        //Print the menu
                        System.out.print(" \n" + menu);
                    }
                    break;

                //Default case
                default:
                    break;
            }
        }while(!done);
    }
}

