package thread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/14 <br>
 * @since V9.0 <br>
 */
public class GuardObject {

    private Object response;

    public Object get() {
        synchronized (this) {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object obj) {
        synchronized (this) {
            this.response = obj;
            this.notifyAll();
        }
    }


}
