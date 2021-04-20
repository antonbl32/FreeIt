package by.antonsh.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
@Builder()
public class Car {
    private String model;
    private int maxSpeed;
    private int price;

    public void start() throws MyException {
        Random random = new Random();
        if (random.nextInt(20) % 2 == 0) {
            throw new MyException("четное число");
        } else {
            System.out.println(this.toString() + " завелся!");
        }
    }

    public static void main(String[] args) {
        Car car = Car.builder().maxSpeed(150).model("Aura").price(35000).build();
        Car car2 = Car.builder().maxSpeed(160).model("Buken").price(31000).build();
        try {
            car.start();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            car2.start();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
