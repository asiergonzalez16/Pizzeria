package Pizzeria;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Customer implements Serializable{
    int id_customer;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Set<Order> orders = new HashSet<>();

    public Customer(int id_Customer, String name, String address, String email, String phone) {
        super();
        this.id_customer = id_Customer;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }



    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public Customer(){}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Order getOrders(int i) {
        Iterator<Order> it = orders.iterator();
        for (int j = 0; j < i; j++) {
            it.next();
        }
        return it.next();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public int getSizeOrder(){
        return orders.size();
    }

    @Override
    public String toString() {
        return "Pizzeria.Customer [id_Cusomer= " + id_customer + ", name= " + name
                + ", address= " + email + ", phone= "
                + phone + "]";
    }
}
