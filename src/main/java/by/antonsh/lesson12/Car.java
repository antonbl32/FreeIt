package by.antonsh.lesson12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
public class Car implements Serializable {
    private static final long serialVersionUID = -6156266277099874619L;
    private String brand;
    private double speed;
    private long price;
}
class Runner{
    public static void main(String[] args) throws IOException {
        Car car=new Car("BMW",217.5,37000);

        try(FileOutputStream outputStream = new FileOutputStream("car.save");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(car);
        }
        System.out.println("writing data.");
        try(FileInputStream fileInputStream=new FileInputStream("car.save");
                ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)){
            Car car1= (Car) objectInputStream.readObject();
            System.out.println(car1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
