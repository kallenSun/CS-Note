package thread.retrantLock;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
public class Demo1 {

    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(5);
        threadLocal.set(10);

        System.out.println(threadLocal.get());
    }
}
