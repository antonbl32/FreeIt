package by.antonsh.lesson3;

public class Ex3 {
    public static void main(String[] args) {
        int summ=1;
        for (int i = 2; i <=256 ; i*=2) {
            summ+=i;
            System.out.println(i +" <-> "+summ);
        }

    }
}
