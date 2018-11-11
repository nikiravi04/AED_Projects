/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4_analytics;

import assignment_4.entities.Business;
import assignment_4.entities.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.Item;

/**
 *
 * @author nikitaravindran
 */
public class AnalysisHelper {
    
    
    public void threeBestCustomers(){
        

        final Map<Integer, Integer> customerRevenue = new HashMap<Integer, Integer>();
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        for(Order order : orders.values()) {
            int productId = order.getItem().getProductId();
            int min = products.get(productId).getMinPrice();
            int selling = order.getItem().getSalesPrice();
            int quantity = order.getItem().getQuantity();
            int revenue = (selling - min) * quantity;
            int totalRevenue = 0;
            if(customerRevenue.containsKey(order.getCustomerId()))
                totalRevenue = customerRevenue.get(order.getCustomerId());
            totalRevenue += revenue;
            customerRevenue.put(order.getCustomerId(), totalRevenue);
        }
        
        List<Integer> customerList = new ArrayList<>(customerRevenue.keySet());
        Collections.sort(customerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer customerId1, Integer customerId2) {
                //so as to get descending list
                return customerRevenue.get(customerId2) - customerRevenue.get(customerId1);
            }
        });
        
        System.out.println("\n3 best customers: ");
        for(int i=0; i<customerList.size() && i<3; i++) {
            int id = customerList.get(i);
            System.out.println(id + " revenue: " + customerRevenue.get(id));
        }

    }
    
    public void getTotalRevenue() {
        int totalRevenue = 0;
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        Map<Integer, Item> items = DataStore.getInstance().getItem();
        
        for(Order order : orders.values()) {
            int productId = order.getProductId();
            int min = products.get(productId).getMinPrice();
            int selling = items.get(productId).getSalesPrice();
            int quantity = items.get(productId).getQuantity();
            int revenue = selling * quantity;
            totalRevenue += revenue;
        }
        System.out.println("\nTotal revenue for the year: " + totalRevenue);
    }
    
    
}