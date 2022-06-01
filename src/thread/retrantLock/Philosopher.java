package thread.retrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家就餐问题
 */
public class Philosopher extends Thread{

    Chopstick left;

    Chopstick right;

    public Philosopher(String name,Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        if (left.tryLock()) {
            try {
                if (right.tryLock()) {
                    try {

                    } finally {
                        right.unlock();
                    }
                }
            } finally {
                left.unlock();
            }
        }
    }

    private void eat() {
        System.out.println("eat");
    }
}

class Chopstick extends ReentrantLock {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
