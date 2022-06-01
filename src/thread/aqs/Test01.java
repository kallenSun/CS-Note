package thread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/24 <br>
 * @since V9.0 <br>
 */
public class Test01 {

    private static Lock lock = new ReentrantLock();

    private static Condition a = lock.newCondition();

    private static Condition b = lock.newCondition();

    private static Condition c = lock.newCondition();

    private static int count = 0;

    public static void main(String[] args) {

    }
}
