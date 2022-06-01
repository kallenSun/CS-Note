package thread.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/14 <br>
 * @since V9.0 <br>
 */
public class ReadWriterLock {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.put(String.valueOf(num), num + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.get(num + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println("Thread" + Thread.currentThread().getName() + "正在写操作" + key);

        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put(key, value);

        System.out.println("Thread" + Thread.currentThread().getName() + "写完了" + key);
    }

    public Object get(String key) {
        Object result;
        System.out.println(Thread.currentThread().getName() + "正在读操作" + key);

        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        result = map.get(key);

        System.out.println("Thread" + Thread.currentThread().getName() + "取到了" + key);
        return result;
    }

}

