package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/12 <br>
 * @since V9.0 <br>
 */
public class LockSaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        },"CC").start();

    }
}

class Ticket {

    private int number = 30;

    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        try {
            lock.lock();
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "卖出" + number-- + "剩下" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
