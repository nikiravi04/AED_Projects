/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshalneelkamal
 */
public class Order {
    int orderId;
    int salesId;
    int customerId;
    int productId;
    private ArrayList<Item> items;
    private List<Product> products;

    
    public Order(int orderId, int salesId, int customerId,int productId) {
        this.orderId = orderId;
        this.salesId = salesId;
        this.customerId = customerId;
        this.productId = productId;
        this.items = new ArrayList<>();
        this.products = new ArrayList<>();
        //System.out.println("items" +items);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
  

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
     public String toString(){
        return String.valueOf(orderId);//customerId;
    }
    
    
}
