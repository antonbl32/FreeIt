package by.antonsh.mysql.DAO;

import by.antonsh.mysql.configuration.ConnectionDB;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.facade.ItemFromDB;
import by.antonsh.mysql.facade.OrderFromBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Order getOrderById(Integer id) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("select * from myorder o join " +
                    "items i on i.order_id=o.id and o.id=?");
            statement.setInt(1,id);
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

    @Override
    public List<Order> getAllOrders() {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql="select * from myorder";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Order> list=new ArrayList<>();
            while(resultSet.next()){
                list.add(getOrderById(resultSet.getInt("id")));
            }
            return list;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrdersWhichHaveItem(Item item) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql="select i.order_id from items i where i.item_id="+item.getId();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Integer> list=new ArrayList<>();
            while(resultSet.next()){
                list.add(resultSet.getInt("order_id"));
            }
            return list;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrderLessPriceAndLessItemsOfCount(int price, int count) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("select * from (select sum(price) as pr,allitems.order_id\n" +
                    "                      FROM item i JOIN items as allitems\n" +
                    "                      on i.iditem=allitems.item_id where allitems.count<?\n" +
                    "                     ) as result where result.pr<?;");
            statement.setInt(1,count);
            statement.setInt(2,price);
            ResultSet resultSet = statement.executeQuery();
            List<Integer> list=new ArrayList<>();
            while(resultSet.next()){
                list.add(resultSet.getInt("order_id"));
            }
            return list;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrderWithoutItemAndGetInDate(Item item, LocalDate localDate) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql="select i.order_id from items i where i.item_id!="+item.getId();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Integer> list=new ArrayList<>();
            while(resultSet.next()){
                list.add(resultSet.getInt("order_id"));
            }
            return list;
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
