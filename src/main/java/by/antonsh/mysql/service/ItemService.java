package by.antonsh.mysql.service;

import by.antonsh.mysql.configuration.ConnectionDB;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.facade.ItemFromDB;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private Logger logger = LoggerFactory.getLogger(ItemService.class);

    public Item getItemById(Integer id) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM item i where i.iditem=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            ItemFromDB fromDB = new ItemFromDB();
            resultSet.next();
            Item item = fromDB.getItem(resultSet);
            return item;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Item> getAllItems() {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM item";
            ResultSet resultSet = statement.executeQuery(sql);
            ItemFromDB fromDB = new ItemFromDB();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(fromDB.getItem(resultSet));
            }
            return items;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
