package by.antonsh.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ItemInOrder {
    private long id_order;
    private Map<Item, Integer> items=new HashMap<>();
}
