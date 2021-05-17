package by.antonsh.lesson13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private String id;
    private String name;
    private MotherBoard motherBoard;
    private HDD hdd;
    private VCard vCard;
    private double price;
    public void setAllPrice(){
        this.price= motherBoard.getPrice()+hdd.getPrice()+vCard.getPrice();
    }
}
