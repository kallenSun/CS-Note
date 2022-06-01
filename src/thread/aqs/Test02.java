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
 * @CreateDate 2022/2/26 <br>
 * @since V9.0 <br>
 */
public class Test02 {


    private static Lock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();

    private static Condition conditionB = lock.newCondition();

    private static Condition conditionC = lock.newCondition();


    private static volatile int count = 0;

    public static void main(String[] args) {

    }

}
