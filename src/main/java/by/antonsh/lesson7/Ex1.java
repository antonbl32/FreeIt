package by.antonsh.lesson7;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.util.concurrent.ThreadLocalRandom;

/*
Разработать иерархию классов подобную схеме
 */
public class Ex1 {
    public static void main(String[] args) {
        String[] brand = {"Audi", "Mercedes", "BMW", "Honda", "Ford"};
        Car car = Car.builder().numberOfPassengers(ThreadLocalRandom.current().nextInt(1, 8))
                .brand(brand[ThreadLocalRandom.current().nextInt(0, 4)])
                .gasMileage(ThreadLocalRandom.current().nextDouble(5, 20))
                .maxSpeed(ThreadLocalRandom.current().nextDouble(120, 240))
                .power(ThreadLocalRandom.current().nextDouble(80, 380))
                .weight(ThreadLocalRandom.current().nextDouble(1500, 3100))
                .wheels(ThreadLocalRandom.current().nextInt(3, 4))
                .build();
        System.out.println(car);
        car.getMealageTime(2.6);
    }
}

@Data
@SuperBuilder
class Machine {
    private double power;
    private double maxSpeed;
    private double weight;
    private String brand;

    private double convertHPToKW(double hp) {
        return hp * 0.74;
    }

    @Override
    public String toString() {
        return "\n{" +
                " Мощность(л\\с): " + power +
                " Мощность(к\\В): " + convertHPToKW(power) +
                ", Максимальная скорость(к\\мч): " + maxSpeed +
                ", Масса(кг): " + weight +
                ", Марка авто: '" + brand + '\'' +
                '}';
    }
}

@Data
@SuperBuilder
class LandTransport extends Machine {
    private int wheels;
    private double gasMileage;
    @Override
    public String toString() {
        return "{" +
                "Количество колес: " + wheels +
                ", Расход топлива в л/100км: " + gasMileage +
                "} " + super.toString();
    }
}

@Data
@SuperBuilder
class Car extends LandTransport {
    private int numberOfPassengers;

    @Override
    public String toString() {
        return "Car{" +
                "Количество пассажиров: " + numberOfPassengers +
                "} " + super.toString();
    }

    public void getMealageTime(double time) {
        System.out.println("За время " +
                time +
                " часа, автомобиль " +
                super.getBrand() +
                " двигаясь с максимальной скоростью " +
                super.getMaxSpeed() +
                " км/ч израсходует " +
                super.getMaxSpeed() * time / 100 * super.getGasMileage() +
                " литров топлива");
    }
}

class Track extends LandTransport {

    protected Track(LandTransportBuilder<?, ?> b) {
        super(b);
    }
}

class AirTransport extends Machine {


    protected AirTransport(MachineBuilder<?, ?> b) {
        super(b);
    }
}