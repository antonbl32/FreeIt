package by.antonsh.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private LocalDate date;
    private Map<Item, Integer> items=new HashMap<>();

    public double getPriceFromOrder(){
        double price=0;
        for (Map.Entry<Item,Integer> entry:items.entrySet()) {
            price += entry.getKey().getPrice()* entry.getValue();
        }
        return price;
    }
}
