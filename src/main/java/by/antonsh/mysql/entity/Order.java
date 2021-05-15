package by.antonsh.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private ItemInOrder itemsInOrder;
    private LocalDate date;
}
