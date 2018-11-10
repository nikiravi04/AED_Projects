/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4_analytics;

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
        
        Map<Integer, Integer> revenue = new HashMap<Integer,Integer>();
        Map<Integer,Order> orders = DataStore.getInstance().getOrder();
        Map<Integer,Product> product = DataStore.getInstance().getProduct();
        
        
        
        
    }
    
}
