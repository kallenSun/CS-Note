package thread.juc;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/21 <br>
 * @since V9.0 <br>
 */
public class Test2 {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            final int id = i;
            new Thread(()->{
                queue.put(new Message(id, id));
            }, "生产者"+ i).start();
        }

        new Thread(()->{
            while (true) {
                Message message = queue.take();
            }
        }, "消费者者").start();
    }

}

class MessageQueue {

    private int capacity = 2;

    private final LinkedList<Message> list = new LinkedList<>();

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public Message take() {

        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.notifyAll();
            Message message = list.removeFirst();
            System.out.println("已经消费了消息" + message);
            return message;

        }
    }

    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    System.out.println("队列已满，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            System.out.println(Thread.currentThread().getName() + "生产了消息" + ":" + message.getId());
            list.notifyAll();
        }
    }
}

final class Message {

    private int id;

    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}