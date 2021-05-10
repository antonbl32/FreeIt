package by.antonsh.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
/*
Создать свой функциональный интерфейс для вывода на консоль данных объекта.
С помощью лямбда-выражения вывести данные для объектов типа String и Integer.
 */
public class Ex1 {
    public static void main(String[] args) {
        User user = new User("Denis", 13);
        UserDetails userDetails = u -> u.toString();
        System.out.println(userDetails.getDetails(user));
    }
}
@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
}

@FunctionalInterface
interface UserDetails {
    String getDetails(User user);
}
