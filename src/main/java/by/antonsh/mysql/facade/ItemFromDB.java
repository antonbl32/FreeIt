package by.antonsh.mysql.facade;

import by.antonsh.mysql.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemFromDB {
    public Item getItem(ResultSet resultSet) throws SQLException {
        Item item=new Item();
        try {
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("desc"));
            item.setPrice(resultSet.getDouble("price"));
            item.setId(resultSet.getInt("iditem"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}
