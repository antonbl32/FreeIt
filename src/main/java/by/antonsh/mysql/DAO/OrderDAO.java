package by.antonsh.mysql.DAO;

import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    List<Integer> getOrdersWhichHaveItem(Item item);
    List<Integer> getOrderLessPriceAndLessItemsOfCount(int price, int count);
    List<Integer> getOrderWithoutItemAndGetInDate(Item item, LocalDate localDate);

}
