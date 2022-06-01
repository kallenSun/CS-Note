package thread.dcl;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/15 <br>
 * @since V9.0 <br>
 */
public class Singleton {

    public static void main(String[] args) {
    }

    private Singleton() {}

    private static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
