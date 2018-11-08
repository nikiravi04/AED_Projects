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
public class SupplierDirectory {
    
    private ArrayList<Supplier> supp = new ArrayList<>();
    private ArrayList<Product> prod = new ArrayList<>();

    public ArrayList<Supplier> getSupp() {
        return supp;
    }

    public void setSupp(ArrayList<Supplier> supp) {
        this.supp = supp;
    }

    public ArrayList<Product> getProd() {
        return prod;
    }

    public void setProd(ArrayList<Product> prod) {
        this.prod = prod;
    }
    
    public SupplierDirectory(ArrayList<Supplier> supp){
    
        this.supp = supp;
    }
     
    
}
