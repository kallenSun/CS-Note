package thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/13 <br>
 * @since V9.0 <br>
 */
public class DeadLock {

    static Object a = new Object();

    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "try to get thread b");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "get thread b");
                }
            }
        }, "A").start();


        new Thread(()->{
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "try to get thread a");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "get thread a");
                }
            }
        }, "A").start();


    }
}
