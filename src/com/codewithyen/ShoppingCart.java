package com.codewithyen;

import java.util.ArrayList;

public class ShoppingCart {
    private final String customerName;
    private final String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<>();


    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
    }

    //Define the function "addItem()"
    public void addItem(ItemToPurchase ItemToPurchase){
        this.cartItems.add(cartItems.size(), ItemToPurchase);
    }

    //Define the function "removeItem()"
    public void removeItem(String itemToRemove) {
        //Loop to iterate the items
        for(int i = 0; i < cartItems.size(); i++)
        {
            //Check the condition
            if(cartItems.get(i).getItemName().equalsIgnoreCase(itemToRemove)){
                //True, remove an item from the cart
                cartItems.remove(i);
            }
        }
    }

    //Define the function "modifyItem()"
    public void modifyItem(ItemToPurchase itemToPurchase){
        //Loop to iterate
        for (ItemToPurchase cartItem : cartItems) {
            //Check the condition
            if (cartItem.getItemName().equals(itemToPurchase.getItemName())) {
                //Change the item quantity
                cartItem.setItemQuantity(itemToPurchase.getItemQuantity());
            }
        }
    }

    //Define the function "getNumItemsInCart()"
    public int getNumItemsInCart() {
        //Initialize the variable
        int items = 0;
        //Loop to iterate the item
        for (ItemToPurchase cartItem : cartItems) {
            //Assign number of items to "items"
            items += cartItem.getItemQuantity();
        }
        //Return the number of items
        return items;
    }

    //Define the function "getCostOfCart()"
    public int getCostOfCart(){
        //Initialize the variable
        int totalPrice = 0;
        //Loop to iterate the item
        for (ItemToPurchase cartItem : cartItems) {
            //Calculate the total cost
            totalPrice += (cartItem.getItemPrice() * cartItem.getItemQuantity());
        }
        //Return the cost
        return totalPrice;
    }

    //Define the function "printTotal()"
    public void printTotal(){
        //Loop to iterate the item
        for (ItemToPurchase cartItem : cartItems) {
            //Print the cart items
            System.out.println(cartItem.printItemCost());
        }
        //Print the new line
        System.out.println();
    }

    //Define the function "printDescriptions()"
    public void printDescriptions(){
        //Print the statement
        System.out.println("Item Descriptions");
        //Loop to iterate the item
        for (ItemToPurchase cartItem : cartItems) {
            //Print the cart items
            System.out.println(cartItem.printItemDescription());
        }
    }

    //Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return currentDate;
    }
}
