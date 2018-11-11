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
 * @author TechieTribe (ravindran.n@husky.neu.edu , varmavimal.v@husky.neu.edu, gubballi.s@husky.neu.edu)
 */
public class Order {
    int orderId;
    int salesId;
    int customerId;
    int productId;
    private ArrayList<Item> items;
    private List<Product> products;

    Item item;

    
    public Order(int orderId, int salesId, int customerId,Item item) {
        this.orderId = orderId;
        this.salesId = salesId;
        this.customerId = customerId;
        this.productId = productId;
        this.items = new ArrayList<>();
        this.products = new ArrayList<>();
        this.item = item;
        //System.out.println("items" +items);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
    
    
//    public int orderTotal(){
//    
//        int sum=0;
//        for(Product i : Product){
//        
//            sum = sum + i.getOrderItemTotal();
//
//        }
//        
//        return sum;
//        
//    
//    }

     public String toString(){
        return String.valueOf(orderId);//customerId;
    }
    
    
}
