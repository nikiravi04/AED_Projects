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
    AnalysisHelper helper;
    
    public GateWay() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        productReader = new DataReader(generator.getProductCataloguePath());
        orderReader = new DataReader(generator.getOrderFilePath());
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
        
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        String[] orderRow;
        printRow(orderReader.getFileHeader());
        while((orderRow = orderReader.getNextRow()) != null){
            printRow(orderRow);
        }
        System.out.println("_____________________________________________________________");
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
            printRow(prodRow);
        }
        runAnalysis();
    }
    
    private void generateCustomer(String[] row){
        int customerId = Integer.parseInt(row[0]);
        Customer cust = new Customer(customerId, row[1], row[2],row[3],row[4]);
        DataStore.getInstance().getCustomer().put(customerId,cust);
    }
    
    private Order generateOrder(String[] row){
        int orderId = Integer.parseInt(row[0]);
        int salesId = Integer.parseInt(row[1]);
        int customerId = Integer.parseInt(row[2]);
        int productId = Integer.parseInt(row[3]);
        Order order = new Order(orderId, salesId,customerId,productId);
        DataStore.getInstance().getOrder().put(orderId,order);
        
        Map<Integer,Item> items = DataStore.getInstance().getItem();
        if(items.containsKey(productId))
            items.get(productId).getOrders().add(order);
        return order;
    }
    
    private void generateProduct(String[] row){
        int productId = Integer.parseInt(row[0]);
        int productPrice = Integer.parseInt(row[4]);
        Product product = new Product(productId, row[1], row[2],row[3],productPrice);
        DataStore.getInstance().getProduct().put(productId,product);
    }
    
    private void generateSalesPerson(String[] row){
        int salesId = Integer.parseInt(row[0]);
        int orderId = Integer.parseInt(row[1]);
        SalesPerson salesperson = new SalesPerson(salesId,orderId,row[2],row[3],row[4],row[5]);
        DataStore.getInstance().getSalesperson().put(salesId,salesperson);
    }
    
 
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
        
    }
    
    private void runAnalysis(){
        
        
    
    }
    
}
