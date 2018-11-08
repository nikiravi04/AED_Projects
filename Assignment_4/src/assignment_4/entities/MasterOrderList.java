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
public class MasterOrderList {
    
    private ArrayList<Order> order = new ArrayList<>();
    
    public MasterOrderList(ArrayList<Order> order){
    
        this.order = order;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }
    
   
    
}
