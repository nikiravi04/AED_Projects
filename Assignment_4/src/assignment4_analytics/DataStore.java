/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4_analytics;

import assignment_4.entities.Business;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nikitaravindran
 */
public class DataStore {
    
    private static DataStore datastore;
    
    private Map<Integer,Customer> customer;
    private Map<Integer, Order> order;
    private Map<Integer, SalesPerson> salesperson;
    private Map<Integer, Product> product;
    private Map<Integer, Item> item;
    private Map<Integer, Business> business;

    
    
    private DataStore(){
        customer = new HashMap<>();
        order = new HashMap<>();
        salesperson = new HashMap<>();
        product = new HashMap<>();
        item = new HashMap<>();
        business = new HashMap<>();
    }
    
    public static DataStore getInstance(){
        if(datastore == null)
            datastore = new DataStore();
        return datastore;
    }

    public static DataStore getDatastore() {
        return datastore;
    }

    public static void setDatastore(DataStore datastore) {
        DataStore.datastore = datastore;
    }

    public Map<Integer, Business> getBusiness() {
        return business;
    }

    public void setBusiness(Map<Integer, Business> business) {
        this.business = business;
    }
    
    
    public Map<Integer, Item> getItem() {
        return item;
    }

    public void setItem(Map<Integer, Item> item) {
        this.item = item;
    }

    public Map<Integer, Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Map<Integer, Customer> customer) {
        this.customer = customer;
    }

    public Map<Integer, Order> getOrder() {
        return order;
    }

    public void setOrder(Map<Integer, Order> order) {
        this.order = order;
    }

    public Map<Integer, SalesPerson> getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Map<Integer, SalesPerson> salesperson) {
        this.salesperson = salesperson;
    }

    public Map<Integer, Product> getProduct() {
        return product;
    }

    public void setProduct(Map<Integer, Product> product) {
        this.product = product;
    }
    
  
}
