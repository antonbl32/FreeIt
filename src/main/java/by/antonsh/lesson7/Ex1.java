package by.antonsh.lesson7;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.concurrent.ThreadLocalRandom;

/*
Разработать иерархию классов подобную схеме
Все классы разместил в одном файле для более наглядной проверки задания
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

@Data
@SuperBuilder
class Track extends LandTransport {
    private double carryingCapacity;

    @Override
    public String toString() {
        return "Грузовой транспорт{" +
                "Грузоподьемность: " + carryingCapacity +
                "} " + super.toString();
    }

    /**
     * Метод проверяет применим ли этот транспорт для этого груза
     *
     * @param weight масса загружаемого груза
     */
    public void isOverWeight(double weight) {
        int isOver = Double.compare(carryingCapacity, weight);
        if (isOver >= 0) {
            System.out.println("Грузовик загружен.");
        } else {
            System.out.println("Вам нужен грузовик по больше.");
        }
    }
}

@Data
@SuperBuilder
class AirTransport extends Machine {
    private double wingspan;
    private double runwayLength;

    @Override
    public String toString() {
        return " \nВоздушный транспорт{" +
                " Размах крыла: " + wingspan +
                ", Длина взлетно-посадочной полосы: " + runwayLength +
                "} " + super.toString();
    }
}

@Data
@SuperBuilder
class CivilAircraft extends AirTransport {
    private int passengers;
    private boolean isBusiness;

    /**
     * Метод проверяет возможность вместить пассажиров и выводит сообщение
     *
     * @param passengers количество загружаемый пассажиров
     */
    public void isOverSitting(int passengers) {
        int isOver = Integer.compare(this.passengers, passengers);
        System.out.println("в самолет садится: "+passengers+" пассажиров.");
        if (isOver >= 0) {
            System.out.println("Самолет заполнен.");
        } else {
            System.out.println("Вам нужен самолет по больше.");
        }
    }

    @Override
    public String toString() {
        return "CivilAircraft{" +
                "passengers=" + passengers +
                ", isBusiness=" + isBusiness +
                "} " + super.toString();
    }
}

@Data
@SuperBuilder
class WarPlane extends AirTransport {
    private boolean ejectionSystem;
    private int numberOfMissiles;

    @Override
    public String toString() {
        return "Военный самолет{" +
                " наличие системы катапультирования: " + ejectionSystem +
                ", количество ракет: " + numberOfMissiles +
                "} " + super.toString();
    }
    public void shoot(){
        if(numberOfMissiles>0){
            System.out.println("Ракета пошла…");
            numberOfMissiles--;
        }else{
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void isEjectionSystem(){
        if(ejectionSystem){
            System.out.println("Катапультирование прошло успешно.");
        }else{
            System.out.println("У вас нет такой системы...");
        }
    }
}