package thread.aqs;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/26 <br>
 * @since V9.0 <br>
 */
public class Test03 implements Runnable{

    private static final Object lock = new Object();

    private static final int max = 100;

    private static int count = 0;

    private int index;

    public Test03(int index) {
        this.index = index;
    }

    @Override
    public void run() {
       while (count < max) {
            synchronized (lock) {
                while (count % 3 == index) {
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
           System.out.println(Thread.currentThread().getName() + ":" + "走到这");
        }
    }

    public static void main(String[] args) {}
}
