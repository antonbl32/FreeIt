package by.antonsh.lesson9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

@Version(version = 5.6)
public class MyService {
    private String name;
    private int number;

    public MyService(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService myService = (MyService) o;
        return number == myService.number &&
                Objects.equals(name, myService.name);
    }
    private void thisClassInfo(){
        System.out.println("class name "+getClass().getName()+" class constructors "+getClass().getConstructors()
                + "\n class annotation"+getClass().getAnnotations());
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "MyService{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public MyService() {
    }
}
class GetWithReflection{
    public static void main(String[] args) {
        MyService myService=new MyService();
        if(myService.getClass().isAnnotationPresent(Version.class)){

            try {
                myService.setName("Bbbb");
                myService.setNumber(1005);
                Method m=myService.getClass().getDeclaredMethod("thisClassInfo");
                m.setAccessible(true);
                m.invoke(myService);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
