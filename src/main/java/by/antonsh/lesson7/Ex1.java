package by.antonsh.lesson7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
Разработать иерархию классов подобную схеме
 */
public class Ex1 {
    public static void main(String[] args) {
        String[] brand = {"Audi", "Mercedes", "BMW", "Honda", "Ford"};
        Random random = new Random();
        Car car = new Car(ThreadLocalRandom.current().nextDouble(50, 200)
                , ThreadLocalRandom.current().nextDouble(180, 250)
                , ThreadLocalRandom.current().nextDouble(1500, 2000)
                , brand[ThreadLocalRandom.current().nextInt(0, 4)]
                , ThreadLocalRandom.current().nextInt(3, 6)
                , ThreadLocalRandom.current().nextDouble(5, 20)
                , ThreadLocalRandom.current().nextInt(2, 6));
        System.out.println(car);
        car.getMealageTime(2.5);
    }
}

class Machine {
    private double power;
    private double maxSpeed;
    private double weight;
    private String brand;

    public Machine() {
    }

    public Machine(double power, double maxSpeed, double weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

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

class LandTransport extends Machine {
    private int wheels;
    private double gasMileage;

    public LandTransport() {
    }

    public LandTransport(double power, double maxSpeed, double weight, String brand, int wheels, double gasMileage) {
        super(power, maxSpeed, weight, brand);
        this.wheels = wheels;
        this.gasMileage = gasMileage;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getGasMileage() {
        return gasMileage;
    }

    public void setGasMileage(double gasMileage) {
        this.gasMileage = gasMileage;
    }

    @Override
    public String toString() {
        return "{" +
                "Количество колес: " + wheels +
                ", Расход топлива в л/100км: " + gasMileage +
                "} " + super.toString();
    }
}

class Car extends LandTransport {
    private int numberOfPassengers;

    public Car() {
    }

    public Car(double power, double maxSpeed, double weight, String brand, int wheels, double gasMileage, int numberOfPassengers) {
        super(power, maxSpeed, weight, brand, wheels, gasMileage);
        this.numberOfPassengers = numberOfPassengers;
    }

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

}

class AirTransport extends Machine {


}