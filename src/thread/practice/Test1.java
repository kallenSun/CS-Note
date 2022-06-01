package thread.practice;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/17 <br>
 * @since V9.0 <br>
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Print(), "偶数").start();
        Thread.sleep(100);
        new Thread(new Print(), "奇数").start();

    }

    static class Print implements Runnable {

        private static int count = 0;

        private static final Object OBJ = new Object();

        @Override
        public void run() {
            int max = 100;
            while (count < max) {
                synchronized (OBJ) {
                    System.out.println(Thread.currentThread().getName()  + ":" + count);
                    count++;
                    OBJ.notify();
                    if (count < max) {
                        try {
                            OBJ.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
