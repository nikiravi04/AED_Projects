/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private int id;
    private String phone;
    private String address;
    private String type;

    
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
