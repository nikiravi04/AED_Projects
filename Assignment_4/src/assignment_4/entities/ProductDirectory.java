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
public class ProductDirectory {
    
    private ArrayList<Product> productDirectory;
    
    public ProductDirectory(){
        productDirectory = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ArrayList<Product> productDirectory) {
        this.productDirectory = productDirectory;
    }
    
    
    public void deleteProduct(Product product){
        productDirectory.remove(product);
    }
    
    
}
