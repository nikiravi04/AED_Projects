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
public class Customer extends Person{
    
    int customerId;
    private ArrayList<Order> order = new ArrayList<>();

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    Customer() {
   
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public int getTotalRevenue(){
        
        int sum = 0;
        for(Order o : order){
            
            sum = sum + o.orderTotal();

        }
        
        return sum; 
    }

    @Override
    public String toString(){
        return String.valueOf(customerId);//customerId;
    }
}
