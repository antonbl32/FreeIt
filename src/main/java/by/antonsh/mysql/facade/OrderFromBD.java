package by.antonsh.mysql.facade;

import by.antonsh.mysql.entity.ItemInOrder;
import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.service.ItemService;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class OrderFromBD {
    private ItemService itemService = new ItemService();

    public Order getOrderFromBD(ResultSet resultSet) throws SQLException {
        resultSet.next();
        Date date = resultSet.getDate("date");
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setDate(date.toLocalDate());
        ItemInOrder itemInOrder = new ItemInOrder();
        itemInOrder.setId_order(order.getId());
        itemInOrder.getItems().put(itemService.getItemById(
                resultSet.getInt("item_id")),
                resultSet.getInt("count"));
        while (resultSet.next()) {
            itemInOrder.getItems().put(itemService.getItemById(
                    resultSet.getInt("item_id")),
                    resultSet.getInt("count"));
        }
        order.setItemsInOrder(itemInOrder);
        return order;
    }
}
