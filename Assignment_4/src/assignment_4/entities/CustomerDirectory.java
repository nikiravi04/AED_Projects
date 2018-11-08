/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;

/**
 *
 * @author nikitaravindran
 */
public class CustomerDirectory {

    
    
    private ArrayList<Customer> customer = new ArrayList<>();
    
    public CustomerDirectory() {
    }
    
    public CustomerDirectory(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }
     
    public Customer addCustomer(){
        
        Customer customers = new Customer();
        customer.add(customers);
        return customers;
    }

    public ArrayList<Customer> getCustomerinfo() {
        return customer;
    }

    public void setPersoninfo(ArrayList<Customer> customer) {
        this.customer = customer;
    }
    
    
}
