package by.antonsh.mysql.DAO;

import by.antonsh.mysql.configuration.ConnectionDB;
import by.antonsh.mysql.entity.Item;
import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.facade.OrderFromBD;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Order getOrderById(Integer id) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("select * from myorder o join " +
                    "items i on i.order_id=o.id and o.id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            OrderFromBD orderFromBD = new OrderFromBD();
            Order order = orderFromBD.getOrderFromBD(resultSet);
            resultSet.close();
            statement.close();
            return order;
        } catch (SQLException | NullPointerException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql = "select * from myorder";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Order> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(getOrderById(resultSet.getInt("id")));
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException | NullPointerException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrdersWhichHaveItem(Item item) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql = "select i.order_id from items i where i.item_id=" + item.getId();
            return getFromQuery(conn, sql);
        } catch (SQLException | NullPointerException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrderLessPriceAndLessItemsOfCount(int price, int count) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement("select * from (select sum(price) as pr,allitems.order_id\n" +
                    "FROM item i JOIN items as allitems \n" +
                    "on i.iditem=allitems.item_id where allitems.count<? \n" +
                    ") as result where result.pr<?;");
            statement.setInt(1, count);
            statement.setInt(2, price);
            ResultSet resultSet = statement.executeQuery();
            List<Integer> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getInt("order_id"));
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException | NullPointerException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public List<Integer> getFromQuery(Connection conn, String sql) {
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Integer> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getInt("order_id"));
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> getOrderWithoutItemAndGetInDate(Item item, LocalDate localDate) {
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            String sql = "select distinct i.order_id from items i join myorder o on i.order_id=o.id \n" +
                    "where o.date='" + Date.valueOf(localDate) + "' and i.item_id=" + item.getId() + ";";
            return getFromQuery(conn, sql);
        } catch (SQLException | NullPointerException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public void createOrderTodayItem(Order order) {
        Random random=new Random();
        LocalDate localDate = LocalDate.now();
        String sql="insert into myorder (date) values ('"+ localDate + "');";
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            conn.setAutoCommit(false);
            Statement statement=conn.createStatement();
            statement.executeUpdate(sql);
            ResultSet resultSet=statement.executeQuery("select max(id) as mx from myorder");
            resultSet.next();
            order.setId(resultSet.getInt("mx"));
            String sql2="select * from items s join myorder m on s.order_id = m.id where m.date='2021-05-14' group by s.item_id";
            ResultSet resultSet1=statement.executeQuery(sql2);
            Set<Integer> itemKey=new HashSet<>();
            while (resultSet1.next()){
                itemKey.add(resultSet1.getInt("item_id"));
            }
            Iterator<Integer> iterator= itemKey.iterator();
            String sql3="insert into items (item_id, count, order_id) values (?,?,?)";
            PreparedStatement preparedStatement= conn.prepareStatement(sql3);
            for (int i = 0; i < itemKey.size(); i++) {
                preparedStatement.setInt(1,iterator.next());
                preparedStatement.setInt(2,random.nextInt(5));
                preparedStatement.setInt(3,order.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            conn.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteOrderWithItemsAndCount(Item item, Integer count) {
        String sql="select * from items i where i.item_id="+item.getId()
                +" and i.count="+count+";";
        Set<Integer> setOfOrderForDelete=new HashSet<>();
        Set<Integer> setOfItemsForDelete =new HashSet<>();
        try (Connection conn = ConnectionDB.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            conn.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                setOfOrderForDelete.add(resultSet.getInt("order_id"));
                setOfItemsForDelete.add(resultSet.getInt("id"));
            }
            String sqlOrder="DELETE FROM myorder where id=?";
            String sqlItems="DELETE FROM items where item_id=?";
            PreparedStatement ps1= conn.prepareStatement(sqlOrder);
            PreparedStatement ps2= conn.prepareStatement(sqlItems);
            Iterator<Integer> iteratorOrder=setOfOrderForDelete.iterator();
            Iterator<Integer> iteratorItem=setOfItemsForDelete.iterator();
            for (int i = 0; i < setOfOrderForDelete.size(); i++) {
                ps1.setInt(1,iteratorOrder.next());
            }
            for (int i = 0; i < setOfItemsForDelete.size(); i++) {
                ps2.setInt(1,iteratorItem.next());
            }
            ps1.executeBatch();
            ps2.executeBatch();
            conn.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}