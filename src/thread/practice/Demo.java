package thread.practice;

/**
 * 创建三个线程分别打印1，2，3
 */
public class Demo {

    public static final Object obj = new Object();

    public static int count = 0;

    public static int max = 100;

    public static void main(String[] args) {
        new Thread(new Printer(), "thread 1").start();

        new Thread(new Printer(), "thread 2").start();

        new Thread(new Printer(), "thread 3").start();

    }

    static class Printer implements Runnable {

        public static final Object obj = new Object();

        public static int count = 0;

        public static int max = 100;

        @Override
        public void run() {
            while (count < max) {
                synchronized (obj) {
                    while (count < 100) {
                        if (count % 3 == 0) {
                            System.out.println(Thread.currentThread().getName()  + ":" + count);
                        } else if (count % 3 == 1) {
                            System.out.println(Thread.currentThread().getName()  + ":" + count);
                        } else if (count % 3 == 2) {
                            System.out.println(Thread.currentThread().getName()  + ":" + count);
                        }
                        count++;
                        obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}


