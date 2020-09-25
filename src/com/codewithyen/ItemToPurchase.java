package com.codewithyen;

public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;

    //Constructors
    public ItemToPurchase() {
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
        this.itemDescription = "none";
    }

    public String printItemCost(){
        return (itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemQuantity*itemPrice));
    }
    public String printItemDescription(){
        return (itemName + ": " + itemDescription + ".");
    }

    //Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    //Getters
    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }
}
