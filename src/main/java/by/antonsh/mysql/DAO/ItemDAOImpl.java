package by.antonsh.mysql.DAO;

import by.antonsh.mysql.configuration.ConnectionDB;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.facade.ItemFromDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
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

    @Override
    public List<Item> getAllItem() {
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
