package by.antonsh.lesson13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MotherBoard {
    private String brand;
    private double price;
    private boolean critical;
}
