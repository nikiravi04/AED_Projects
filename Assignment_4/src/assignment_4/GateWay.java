/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment4_analytics.AnalysisHelper;
import assignment4_analytics.DataStore;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {
    
    DataReader orderReader;
    DataReader productReader;
    DataReader customerReader;
    DataReader itemReader;
    AnalysisHelper helper;
    
    public GateWay() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        productReader = new DataReader(generator.getProductCataloguePath());
        orderReader = new DataReader(generator.getOrderFilePath());
        customerReader = new DataReader(generator.getOrderFilePath());
        itemReader = new DataReader(generator.getOrderFilePath());
        helper = new AnalysisHelper();
    }
    
    public static void main(String args[]) throws IOException{
        
        GateWay inst = new GateWay();
        inst.readData();
        
    }    
        
    private void readData() throws IOException
    {
        DataGenerator generator = DataGenerator.getInstance();
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
//        DataReader orderReader = new DataReader(generator.getOrderFilePath());
//        String[] orderRow;
//        printRow(orderReader.getFileHeader());
//        while((orderRow = orderReader.getNextRow()) != null){
//            printRow(orderRow);
//        }
//        System.out.println("_____________________________________________________________");
//        DataReader productReader = new DataReader(generator.getProductCataloguePath());
//        String[] prodRow;
//        printRow(productReader.getFileHeader());
//        while((prodRow = productReader.getNextRow()) != null){
//            printRow(prodRow);
//        }
        
        String[] row;
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }
        while((row = orderReader.getNextRow()) != null ){
            generateOrder(row);

        }
        runAnalysis();
    }
    
    private void generateCustomer(String[] row){
        int customerId = Integer.parseInt(row[5]);
        Customer cust = new Customer(customerId);
        DataStore.getInstance().getCustomer().put(customerId,cust);
    }
    

    private void generateOrder(String[] row){

        int orderId = Integer.parseInt(row[0]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int productId = Integer.parseInt(row[2]);
        Order order = new Order(orderId, salesId,customerId,productId);
        DataStore.getInstance().getOrder().put(orderId,order);
        

        int itemId = Integer.parseInt(row[1]);
        int quantity = Integer.parseInt(row[3]);
        int sales = Integer.parseInt(row[6]);
        Item item = new Item(itemId,quantity,sales);
        DataStore.getInstance().getItem().put(itemId,item);
   
        
    }
    
   
    
    private void generateProduct(String[] row){

        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        
        Product product = new Product(productId, minPrice,maxPrice,targetPrice);
        DataStore.getInstance().getProduct().put(productId,product);
        
    }
    

//    private Item generateItem(String[] row){
//        int itemId = Integer.parseInt(row[1]);
//        int quantity = Integer.parseInt(row[3]);
//        int sales = Integer.parseInt(row[6]);
//        Item item = new Item(itemId, quan,sales);
//        DataStore.getInstance().getItem().put(itemId,item);
        
//        Map<Integer,Item> items = DataStore.getInstance().getItem();
//        if(items.containsKey(itemId))
//            items.get(itemId).getProducts().add(product);
//        else {
//            Item item = new Item(itemId,quantity,sales);
//            item.getProducts().add(itemId);
//            items.put(itemId,item);
//            return item; 
//        }
        
       
//    }

    
//    private void generateSalesPerson(String[] row){
//        int salesId = Integer.parseInt(row[4]);
//        int orderId = Integer.parseInt(row[0]);
//        SalesPerson salesperson = new SalesPerson(salesId,orderId,row[2],row[3],row[4],row[5]);
//        DataStore.getInstance().getSalesperson().put(salesId,salesperson);
//    }
    
 
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
        
    }
    
    private void runAnalysis(){
        
       helper.threeBestCustomers();
    
    }
    
}
