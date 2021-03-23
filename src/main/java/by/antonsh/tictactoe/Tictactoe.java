package by.antonsh.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Tictactoe {
    public static void main(String[] args) {
        System.out.println("Game Run");
        Thread th1=new Thread(new Runnable() {
            class Tic extends JComponent{
                public static final int FILED_EMPTY=0;
                public static final int FILED_X=10;
                public static final int FILED_0=200;
                int[][] filed;
                boolean isXturn;
                public Tic() {
                    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
                    filed=new int[3][3];
                    initGame();
                }

                private void initGame() {
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j <3 ; ++j) {
                            filed[i][j]=FILED_EMPTY;

                        }

                    }
                    isXturn=true;
                }

                @Override
                protected void processMouseEvent(MouseEvent e) {
                    super.processMouseEvent(e);
                    if(e.getButton()==MouseEvent.BUTTON1){
                        int x=e.getX();
                        int y=e.getY();
                        int i=(int) ((float)x/getWidth()*3);
                        int j=(int) ((float)y/getHeight()*3);
                        if(filed[i][j]==FILED_EMPTY){
                            filed[i][j]=isXturn?FILED_X:FILED_0;
                            isXturn=!isXturn;
                            repaint();
                        }
                    }

                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.RED);
                    g.clearRect(0,0,getWidth(),getHeight());
                    g.drawOval(10,10,100,100);
                    drawGrid(g);
                    drawXO(g);


                }
                void drawGrid(Graphics g){
                    int w=getWidth();
                    int h=getHeight();
                    int dw=w/3;
                    int dh=h/3;
                    g.setColor(Color.BLUE);
                    for (int i = 0; i < 3; i++) {
                        g.drawLine(0,dh*i,w,dh*i);
                        g.drawLine(dw*i,0,dw*i,h);
                    }
                }
                void drawX(int k,int m,Graphics g){

                    int dw=getWidth()/3;
                    int dh=getHeight()/3;
                    g.setColor(Color.BLACK);
                    int x=k*dw;
                    int y=m*dh;
                    g.drawLine(x,y,x+dw,y+dh);
                    g.drawLine(x,y+dh,x+dw,y);
                }
                void drawO(int k,int m,Graphics g){

                    int dw=getWidth()/3;
                    int dh=getHeight()/3;
                    g.setColor(Color.BLACK);
                    int x=k*dw;
                    int y=m*dh;
                    g.drawOval(x+5*dw/100,y,dw*9/10,dh);
                }
                void drawXO(Graphics g){
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            if(filed[i][j]==FILED_X){
                                drawX(i,j,g);
                            }else if (filed[i][j]==FILED_0){
                                drawO(i,j,g);
                            }
                        }
                    }
                }
            }
            @Override
            public void run() {
                JFrame window=new JFrame("Tictactoe");
                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                window.setSize(400,400);
                window.setLayout(new BorderLayout());
                window.setLocationRelativeTo(null);
                window.setVisible(true);
                Tic game=new Tic();
                window.add(game);
            }
            
        });
        th1.start();

        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game Over");


    }
}
