package by.antonsh.lesson9.istart;

public class Spaceport {
    public void start(IStart iStart){
        if(!iStart.preStartCheck()){
            System.out.println("Предстартовая проверка провалена.");
        }else{
            iStart.startEngine();
            for (int i = 10; i <=0 ; i--) {
                System.out.print(i+"   ");
            }
            iStart.start();
        }

    }
}
