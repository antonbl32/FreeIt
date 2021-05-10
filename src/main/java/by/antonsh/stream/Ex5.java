package by.antonsh.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Задать список учеников с принадлежностью к классу (создать класс Student).
Используя средства Stream API 1) вывести список фамилий 2) создать Map со
списком учеников для каждого класса
 */
public class Ex5 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass("first");
        MyClass myClass1 = new MyClass("second");
        Student student = new Student("Arsen", myClass);
        Student student2 = new Student("Denis", myClass1);
        Student student3 = new Student("Max", myClass);
        Student student4 = new Student("Anton", myClass1);
        Student student5 = new Student("Yard", myClass);
        List<Student> list = Arrays.asList(student, student2, student3, student4, student5);
        list.stream().forEach(a -> System.out.println(a.getSoname()));
        Map<MyClass, List<Student>> map = list.stream()
                .collect(Collectors.groupingBy(Student::getMyClass));
    }
}

@Data
@AllArgsConstructor
class MyClass {
    private String name;
}

@Data
@AllArgsConstructor
class Student {
    private String soname;
    private MyClass myClass;
}
