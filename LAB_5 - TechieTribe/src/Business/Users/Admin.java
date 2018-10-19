/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.CustomerDirectory;
import Business.SupplierDirectory;

/**
 *
 * @author TechieTribe (ravindran.n@husky.neu.edu , varmavimal.v@husky.neu.edu, gubballi.s@husky.neu.edu)
 */
public class Admin extends User {
    
    public SupplierDirectory suppDir;
    public CustomerDirectory custDir;
    public Customer customer;
    public Supplier supplier;
    public String password;
    public String userName;
    
    public Admin() {
        super("", "", "Admin");
        suppDir = new SupplierDirectory();
        custDir = new CustomerDirectory();
    }

    public SupplierDirectory getSuppDir() {
        return suppDir;
    }

    public void setSuppDir(SupplierDirectory suppDir) {
        this.suppDir = suppDir;
    }

    public CustomerDirectory getCustDir() {
        return custDir;
    }

    public void setCustDir(CustomerDirectory custDir) {
        this.custDir = custDir;
    }
       
    public Customer addCustomer(){
        Customer newCustomer = new Customer(password,userName);
        custDir.getCustomerList().add(newCustomer);
        return newCustomer;  
    }
    
    public Supplier addSupplier(){
        Supplier newSupplier = new Supplier(password, userName);
        suppDir.getSupplierList().add(newSupplier);
        return newSupplier;
    }
    
    public boolean verify(String password){
        for(User user : this.custDir.getCustomerList()){
            if(user.getPassword().equalsIgnoreCase(password)){
                return false;
            }
        }
        return true;
    }
    
    public boolean verifySupplier(String password){
        for(User user : this.suppDir.getSupplierList()){
            if(user.getPassword().equalsIgnoreCase(password)){
                return false;
            }
        }
        return true;
    }
    
    public boolean searchCustomerUsername(String name){
        for(User user : this.custDir.getCustomerList()){
            if(user.getUserName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }


    public boolean searchSupplierUsername(String name){
        for(User user : this.suppDir.getSupplierList()){
            if(user.getUserName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
    
    
}
