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
public class EmployeeDirectory {
    
    private ArrayList<SalesPerson> salesPerson = new ArrayList<>();
    
    public EmployeeDirectory(ArrayList<SalesPerson> salesPerson){
        
        this.salesPerson = salesPerson;
        
    }

    public ArrayList<SalesPerson> getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(ArrayList<SalesPerson> salesPerson) {
        this.salesPerson = salesPerson;
    }
    
    
    
}
