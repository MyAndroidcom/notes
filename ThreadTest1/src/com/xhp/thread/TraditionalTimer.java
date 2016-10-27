package com.xhp.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TraditionalTimer {

    public static void main(String[] aa)  {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
              System.out.println("bombing");
            }
        },5000);
        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
