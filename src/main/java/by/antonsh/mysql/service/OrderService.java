package by.antonsh.mysql.service;

import by.antonsh.mysql.DAO.OrderDAO;
import by.antonsh.mysql.DAO.OrderDAOImpl;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.entity.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();

    public Order getOrderById(Integer id) {
        return orderDAO.getOrderById(id);
    }
    public void getPriceForEachOrders(){
        List<Order> list = getAllOrders();
        list.stream().forEach(u -> System.out.println("Стоимость заказа №" + u.getId()
                + " равна " + u.getPriceFromOrder()));
    }
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
    public List<Integer> getOrdersWhichHaveItem(Item item){
        return orderDAO.getOrdersWhichHaveItem(item);
    }
    public List<Integer> getOrderLessPriceAndLessItemsOfCount(int price, int count){
        return orderDAO.getOrderLessPriceAndLessItemsOfCount(price,count);
    }
    public void createOrderTodayItem(Order order){
         orderDAO.createOrderTodayItem(order);
    }
    public void deleteOrderWithItemsAndCount(Item item, Integer count){
        orderDAO.deleteOrderWithItemsAndCount(item,count);
    }
}
