package by.antonsh.lesson3;

public class Ex2 {
    public static void main(String[] args) {
        int times=1;
        for (int i = 3; i <= 24; i=i+3) {
            times *=2;
            System.out.println("Будет "+times+" амеб через "+i+" часов");
        }

    }
}
