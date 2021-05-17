package by.antonsh.stream;

/*
Создать свой функциональный интерфейс для вывода на консоль данных объекта.
С помощью лямбда-выражения вывести данные для объектов типа String и Integer.
 */
public class Ex1 {
    public static void main(String[] args) {
        Details details = o -> System.out.println(o);
        int i=1;
        String k="Hello";
        details.getDetails(i);
        details.getDetails(k);
    }
}
@FunctionalInterface
interface Details <T> {
    void getDetails(T t);
}
