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
 * @author TechieTribe (ravindran.n@husky.neu.edu , varmavimal.v@husky.neu.edu, gubballi.s@husky.neu.edu)
 */
public class AnalysisHelper {
    
    
    public void threeBestCustomers(){
        

        final Map<Integer, Integer> customerRevenue = new HashMap<Integer, Integer>();
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        for(Order order : orders.values()) {
            int productId = order.getItem().getProductId();
            //int min = products.get(productId).getMinPrice();
            int selling = order.getItem().getSalesPrice();
            int quantity = order.getItem().getQuantity();
            int revenue = (selling) * quantity;
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
            System.out.println("Customer ID - "+id + ", Revenue - " + customerRevenue.get(id));
        }

    }
    
    public void threeBestSalesPersons(){
        final Map<Integer, Integer> salesRevenue = new HashMap<Integer, Integer>();
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        for(Order order : orders.values()) {
            int productId = order.getItem().getProductId();
            //int min = products.get(productId).getMin();
            int selling = order.getItem().getSalesPrice();
            int quantity = order.getItem().getQuantity();
            int revenue = (selling) * quantity;
            int totalRevenue = 0;
            if(salesRevenue.containsKey(order.getSalesId()))
                totalRevenue = salesRevenue.get(order.getSalesId());
            totalRevenue += revenue;
            salesRevenue.put(order.getSalesId(), totalRevenue);
        }
        
        List<Integer> salesList = new ArrayList<>(salesRevenue.keySet());
        Collections.sort(salesList, new Comparator<Integer>() {
            @Override
            public int compare(Integer salesId1, Integer salesId2) {
                //so as to get descending list
                return salesRevenue.get(salesId2) - salesRevenue.get(salesId1);
            }
        });
        
        System.out.println("\n3 Best sales people: ");
        for(int i=0; i<salesList.size() && i<3; i++) {
            int id = salesList.get(i);
            System.out.println("Sales Persons ID - "+id + ", Revenue - " + salesRevenue.get(id));
        }
    }
    
    public void getTotalRevenue() {
        int totalRevenue = 0;
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        Map<Integer, Item> items = DataStore.getInstance().getItem();
        
        for(Order order : orders.values()) {
            int productId = order.getProductId();
            //int min = products.get(productId).getMinPrice();
            //int selling = items.get(productId).getSalesPrice();
            int selling = order.getItem().getSalesPrice();
            //int quantity = items.get(productId).getQuantity();
            int quantity = order.getItem().getQuantity();
            int revenue = selling * quantity;
            totalRevenue += revenue;
        }
        System.out.println("\nTotal revenue for the year: " + totalRevenue);
    }
    
    public void getThreeMostPopularProduct(){
        final Map<Integer, Integer> productQuantityCount = new HashMap<Integer, Integer>();
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        for(Order order : orders.values()) {
            int totalQuantity = 0;
            if(productQuantityCount.containsKey(order.getItem().getProductId()))
                totalQuantity = productQuantityCount.get(order.getItem().getProductId());
            totalQuantity += order.getItem().getQuantity();
            productQuantityCount.put(order.getItem().getProductId(), totalQuantity);
        }
        List<Integer> productList = new ArrayList<>(productQuantityCount.keySet());
        Collections.sort(productList, new Comparator<Integer>() {
            @Override
            public int compare(Integer productId1, Integer productId2) {
                //so as to get descending list
                return productQuantityCount.get(productId2) - productQuantityCount.get(productId1);
            }
        });
        
        System.out.println("\n3 most popular products: ");
        for(int i=0; i<productList.size() && i<3; i++) {
            int id = productList.get(i);
            System.out.println("Product ID - "+id + ", Quantity - " + productQuantityCount.get(id));
        }
        System.out.println("\n");
    }
    
}