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
import java.util.List;
import java.util.Map;

/**
 *
 * @author nikitaravindran
 */
public class AnalysisHelper {
    
    
    public void threeBestCustomers(){
        
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomer();
        List<Customer> customerList = new ArrayList<>(customers.values());
        
        Collections.sort(customerList, new Comparator<Customer>(){
        
            @Override
            public int compare(Customer o1, Customer o2){
               return o1.getCustomerId()- o2.getCustomerId();

            }
        });
        
        System.out.println("\n Three Best Customers : ");
        for(int i = 0;i < customerList.size() && i<3; i++){
            System.out.println(customerList.get(i));
        }

    
    }
    
}
