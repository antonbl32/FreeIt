package by.antonsh.lesson3;

public class Ex1 {
    public static void main(String[] args) {
        int km=10;
        int increase= (int) (km*1.1);
        for (int i = 1; i < 7; i++) {
            km +=increase;
        }
        System.out.println("пробежал за 7 дней "+km+" км");
    }
}
