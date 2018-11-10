/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;

/**
 *
 * @author harshalneelkamal
 */
public class Item {
    int productId;
    int salesPrice;
    int quantity;
    private ArrayList<Order> orders;

    public Item(int productId, int salesPrice, int quantity) {
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }
    public Item(){
    
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public int getOrderItemTotal(){
        
        int orderItemTotal = 0;
        orderItemTotal = getSalesPrice() * getQuantity();
        return orderItemTotal;
        
    }
    
  

    
    
    
}
