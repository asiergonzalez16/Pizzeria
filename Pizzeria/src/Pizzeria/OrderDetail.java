package Pizzeria;

import Pizzeria.Order;

import java.io.Serializable;
public class OrderDetail implements Serializable {
    private int quantity;

    private float priceEach;


    Order order;
    Pizza pizza;

    int id_order;
    int id_pizza;

public OrderDetail(){}
    public OrderDetail(Pizza pizza, int quantity, float priceEach) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }
    public Order getOrder() {
        return order;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public void setOrder(Order order) {
        this.order = order;
        this.id_order = order.getId_order();
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(float priceEach) {
        this.priceEach = priceEach;
    }
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
        this.id_pizza = pizza.getId_pizza();
    }

    @Override
    public String toString() {
        return "Pizzeria.OrderDetail [id_Order= " + order.getId_order() + ", quantity = " + quantity
                + ", priceEach= " + priceEach +"]";
    }
}
