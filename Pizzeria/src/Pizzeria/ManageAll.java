package Pizzeria;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ManageAll {
    private static SessionFactory factory;

    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageAll MA = new ManageAll();
        FileAccessor fa;
        fa = new FileAccessor();
        fa.readCustomerFile("customers.txt");
        fa.readOrderFile("order.txt");
        fa.readIngredientsFile("ingredientes.txt");
        fa.readPizzaFile("pizza.txt");
        fa.readOrderDetailFile("orderdetail.txt");
        fa.readContieneFile("contiene.txt");
        System.out.println("Customers llegits des del fitxer");
        for (int i = 0; i < fa.listaCustomer.size(); i++) {
            System.out.println(fa.listaCustomer.get(i).toString());
            MA.addCustomer(fa.listaCustomer.get(i));
        }
        System.out.println("Customers llegits de la base de dades");
        MA.listCustomers();



        System.out.println("Orders llegits des del fitxer");
        for (int i = 0; i < fa.listaCustomer.size(); i++) {
            for (int j = 0; j < fa.listaCustomer.get(i).getSizeOrder(); j++) {
                System.out.println(fa.listaCustomer.get(i).getOrders(j).toString());
                MA.addOrder(fa.listaCustomer.get(i).getOrders(j));
            }
        }
        System.out.println("Orders posats de la base de dades");
        MA.listOrder();

//Pizza
        for (int i = 0; i < fa.listaPizza.size(); i++) {
            System.out.println(fa.listaPizza.get(i).toString());
            MA.addPizza(fa.listaPizza.get(i));
        }
        System.out.println("Pizzas añadidas");

        for (int i = 0; i < fa.listaIngredientes.size(); i++) {
            MA.addIngrediente(fa.listaIngredientes.get(i));
        }
        System.out.println("Ingredientes añadidos");


        System.out.println("OrdersDetails llegits des del fitxer");
        for (int i = 0; i < fa.listaCustomer.size(); i++) {
            for (int j = 0; j < fa.listaCustomer.get(i).getSizeOrder(); j++) {
                for (int k = 0; k < fa.listaCustomer.get(i).getOrders(j).getSizeOrderDetail(); k++) {
                    System.out.println(fa.listaCustomer.get(i).getOrders(j).getOrderDetail(k).toString());
                    MA.addOrderDetail(fa.listaCustomer.get(i).getOrders(j).getOrderDetail(k));
                }
            }
        }
        System.out.println("OrdersDetails llegits de la base de dades");
        MA.listOrderDetails();
    }

    public void addCustomer(Customer customer) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer CustomerID = null;
        try {
            tx = session.beginTransaction();

            CustomerID = (Integer) session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void listCustomers() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List customers = session.createQuery("FROM Customer").list();

            for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
                Customer customer = (Customer) iterator.next();
                System.out.println(customer.toString());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void addOrder(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer CustomerID = null;
        try {
            tx = session.beginTransaction();

            CustomerID = (Integer) session.save(order);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void listOrder() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List customers = session.createQuery("FROM Order").list();

            for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
                Order order = (Order) iterator.next();
                System.out.println(order.toString());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void addOrderDetail(OrderDetail orderDetail) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer CustomerID = null;
        try {
            tx = session.beginTransaction();

            CustomerID = (Integer) session.save(orderDetail);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void listOrderDetails() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List customers = session.createQuery("FROM OrderDetail").list();

            for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
                OrderDetail orderDetail = (OrderDetail) iterator.next();
                System.out.println(orderDetail.toString());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void addPizza(Pizza pizza) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer CustomerID = null;
        try {
            tx = session.beginTransaction();
            CustomerID = (Integer) session.save(pizza);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void addIngrediente(Ingrediente ingrediente) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer CustomerID = null;
        try {
            tx = session.beginTransaction();

            CustomerID = (Integer) session.save(ingrediente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

