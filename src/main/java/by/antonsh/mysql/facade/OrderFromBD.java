package by.antonsh.mysql.facade;

import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.service.ItemService;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class OrderFromBD {

    public Order getOrderFromBD(ResultSet resultSet) throws SQLException {
        ItemService itemService = new ItemService();
        resultSet.next();
        Date date = resultSet.getDate("date");
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setDate(date.toLocalDate());
        order.getItems().put(itemService.getItemById(
                resultSet.getInt("item_id")),
                resultSet.getInt("count"));
        while (resultSet.next()) {
            order.getItems().put(itemService.getItemById(
                    resultSet.getInt("item_id")),
                    resultSet.getInt("count"));
        }
        return order;
    }
}
