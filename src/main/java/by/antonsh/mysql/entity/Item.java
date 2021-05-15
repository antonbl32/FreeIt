package by.antonsh.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    private String name;
    private String description;
    private double price;
}
