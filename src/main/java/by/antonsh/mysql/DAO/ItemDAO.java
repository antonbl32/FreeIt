package by.antonsh.mysql.DAO;

import by.antonsh.mysql.entity.Item;

import java.util.List;

public interface ItemDAO {
    Item getItemById(Integer id);
    List<Item> getAllItem();
}
