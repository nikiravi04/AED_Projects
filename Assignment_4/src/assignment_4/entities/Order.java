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
    private List<Item> items;
    private List<Product> Product;
  
    Item item = new Item();
    
    public Order(int orderId, int salesId, int customerId,int productId) {
        this.orderId = orderId;
        this.salesId = salesId;
        this.customerId = customerId;
        this.productId = productId;
        this.Product = new ArrayList<>();
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public int orderTotal(){
    
        int sum=0;
        for(Product i : Product){
        
            sum = sum + i.getOrderItemTotal();

        }
        
        return sum;
        
    
    }

    public List<Product> getProduct() {
        return Product;
    }

    public void setProduct(List<Product> Product) {
        this.Product = Product;
    }
         
    
    
}
