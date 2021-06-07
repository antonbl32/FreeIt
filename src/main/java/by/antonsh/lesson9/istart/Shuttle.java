package by.antonsh.lesson9.istart;

import java.util.Random;

public class Shuttle implements IStart {
    Random random=new Random();
    @Override
    public boolean preStartCheck() {
        if(random.ints(0,10).findFirst().getAsInt()>3){
            return true;
        }
        return false;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели Шатла запущены.\n Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт Шатла!");
    }
}
