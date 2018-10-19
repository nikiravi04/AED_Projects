/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Abstract.User;
import Business.Users.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TechieTribe (ravindran.n@husky.neu.edu , varmavimal.v@husky.neu.edu, gubballi.s@husky.neu.edu)
 */
public class CustomerDirectory {
    
    private List<User> customerList;
    private static CustomerDirectory customerDirectory = null;
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
    }
    
    public static CustomerDirectory getInstance() {
        if (customerDirectory == null) {
            customerDirectory = new CustomerDirectory();
        }
        return customerDirectory;
    }

    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> supplierList) {
        this.customerList = supplierList;
    }
    
}
