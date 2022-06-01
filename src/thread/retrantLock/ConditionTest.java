package thread.retrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/22 <br>
 * @since V9.0 <br>
 */
public class ConditionTest {

    static ReentrantLock ROOM = new ReentrantLock();

    static boolean hasTakeout = false;

    static boolean hasCigarette = false;

    static Condition waitCigaretteSet = ROOM.newCondition();

    static Condition waitTakeout = ROOM.newCondition();


    public static void main(String[] args) {
        new Thread(()->{
            ROOM.lock();
            try {
                System.out.println("是否有烟");
                while (!hasCigarette) {
                    try {
                        waitCigaretteSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("烟有了，开始干活");
            } finally {
                ROOM.unlock();
            }
        },"小南").start();

        new Thread(()->{
            ROOM.lock();
            try {
                System.out.println("是否外卖");
                while (!hasTakeout) {
                    try {
                        waitTakeout.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("外卖有了，开始干活");
            } finally {
                ROOM.unlock();
            }
        }," 小南").start();

        new Thread(()->{
            ROOM.lock();
            try {
                hasTakeout = true;
                waitTakeout.signal();
            } finally {
                ROOM.unlock();
            }
        },"送外卖的").start();

        new Thread(()->{
            ROOM.lock();
            try {
                hasCigarette = true;
                waitCigaretteSet.signal();
            } finally {
                ROOM.unlock();
            }
        },"送烟的").start();
    }
}
