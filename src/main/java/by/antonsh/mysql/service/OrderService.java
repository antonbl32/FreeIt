package by.antonsh.mysql.service;

import by.antonsh.mysql.configuration.ConnectionDB;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.facade.ItemFromDB;
import by.antonsh.mysql.facade.OrderFromBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderService {
    public Order getOrderById(Integer id) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("select * from myorder o right join " +
                    "items i on i.order_id=o.id and o.id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            ItemFromDB fromDB = new ItemFromDB();
            OrderFromBD orderFromBD=new OrderFromBD();
            Order order=orderFromBD.getOrderFromBD(resultSet);
            return order;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
