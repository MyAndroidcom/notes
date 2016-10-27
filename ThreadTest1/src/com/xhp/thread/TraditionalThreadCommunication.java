package com.xhp.thread;

/**
 * 子线程循环10次，主线程循环100次，如此执行50次
 */
public class TraditionalThreadCommunication {
    public static void main(String[] ar) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();
        for (int i = 0; i < 50; i++) {
            business.main(i);
        }
    }

}

class Business {
    private boolean bshouldsub = true;

    synchronized void sub(int i) {
        while (!bshouldsub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int j = 0; j < 10; j++) {
            System.out.println("sub Thread sequence of " + j + ",loop of " + i);
        }
        bshouldsub = false;
        this.notify();
    }

    synchronized void main(int i) {
        while (bshouldsub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 100; j++) {
            System.out.println("main Thread sequence of" + j + ",loop of" + i);
        }
        bshouldsub = true;
        this.notify();

    }
}
