package com.xhp.thread;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer02 {
    private static int count = 0;

    public static void main(String[] args) {
        class MyTimerTask extends TimerTask {

            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(), 2000+2000*count);
            }
        }
        new Timer().schedule(new MyTimerTask(), 2000);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
