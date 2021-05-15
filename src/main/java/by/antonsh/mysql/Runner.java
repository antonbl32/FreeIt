package by.antonsh.mysql;

import by.antonsh.mysql.service.ItemService;
import by.antonsh.mysql.service.OrderService;

public class Runner {
    public static void main(String[] args) {
        ItemService itemService=new ItemService();
        System.out.println(itemService.getAllItems());
        OrderService orderService=new OrderService();
        System.out.println(orderService.getOrderById(1));
    }
}
