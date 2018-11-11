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
public class Business {
    
   private ArrayList<Customer> customer = new ArrayList<>();
   private ArrayList<Item> item = new ArrayList<>();
   private ArrayList<SalesPerson> salesPerson = new ArrayList<>();
   private ArrayList<Order> order = new ArrayList<>();
   private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
   
    

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
    
    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<SalesPerson> getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(ArrayList<SalesPerson> salesPerson) {
        this.salesPerson = salesPerson;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }
   
   
   
    
}
