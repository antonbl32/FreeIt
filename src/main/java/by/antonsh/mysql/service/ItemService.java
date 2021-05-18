package by.antonsh.mysql.service;

import by.antonsh.mysql.DAO.ItemDAO;
import by.antonsh.mysql.DAO.ItemDAOImpl;
import by.antonsh.mysql.entity.Item;

import java.util.List;

public class ItemService {
    private ItemDAO itemDAO=new ItemDAOImpl();

    public Item getItemById(Integer id) {
        return itemDAO.getItemById(id);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItem();
    }
}
