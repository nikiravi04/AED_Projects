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

    public Customer(int customerId,String fname,String lname,String address,String phone) {
        this.customerId = customerId;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
    }

    Customer() {
   
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    
}
