package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/13 <br>
 * @since V9.0 <br>
 */
public class Demo1 {

    /**
     * FutureTask原理 未来任务
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new MyThread1(), "A").start();

        new Thread(new FutureTask<Integer>(() ->{
            return null;
        }));

    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable {

    @Override
    public Integer call() {
        return null;
    }
}
