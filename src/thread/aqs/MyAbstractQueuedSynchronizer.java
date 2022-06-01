package thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

import com.sun.xml.internal.bind.v2.TODO;
import sun.misc.Unsafe;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/24 <br>
 * @since V9.0 <br>
 */
public class MyAbstractQueuedSynchronizer  {

    private Node head;

    private Node tail;

    private volatile int state;

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    private static final long tailOffset = 0;

    /**
     * 每个Node包含以下几个属性
     * prev next
     * waitStatus nextWaiter thread
     */
    static final class Node {

        /***标记是共享节点*/
        static final Node SHARED = new Node();

        /**标记是独占节点**/
        static final Node EXCLUSIVE = null;

        /** 因为超时或者中断，节点会被设置成取消状态，
         * 被取消的节点不会参与到竞争中
         * */
        static final int CANCELLED =  1;

        /**
         * 后继节点处于等待状态
         */
        static final int SIGNAL    = -1;

        static final int CONDITION = -2;

        static final int PROPAGATE = -3;

        /**
         * Status field, taking on only the values:
         *   SIGNAL:     The successor of this node is (or will soon be)
         *               blocked (via park), so the current node must
         *               unpark its successor when it releases or
         *               cancels. To avoid races, acquire methods must
         *               first indicate they need a signal,
         *               then retry the atomic acquire, and then,
         *               on failure, block.
         *   CANCELLED:  This node is cancelled due to timeout or interrupt.
         *               Nodes never leave this state. In particular,
         *               a thread with cancelled node never again blocks.
         *   CONDITION:  This node is currently on a condition queue.
         *               It will not be used as a sync queue node
         *               until transferred, at which time the status
         *               will be set to 0. (Use of this value here has
         *               nothing to do with the other uses of the
         *               field, but simplifies mechanics.)
         *   PROPAGATE:  A releaseShared should be propagated to other
         *               nodes. This is set (for head node only) in
         *               doReleaseShared to ensure propagation
         *               continues, even if other operations have
         *               since intervened.
         *   0:          None of the above
         *
         * The values are arranged numerically to simplify use.
         * Non-negative values mean that a node doesn't need to
         * signal. So, most code doesn't need to check for particular
         * values, just for sign.
         *
         * The field is initialized to 0 for normal sync nodes, and
         * CONDITION for condition nodes.  It is modified using CAS
         * (or when possible, unconditional volatile writes).
         */
        volatile int waitStatus;

        volatile Node prev;

        volatile Node next;

        volatile Thread thread;

        Node nextWaiter;

        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null) {
                throw new NullPointerException();
            } else {
                return p;
            }
        }

        Node() {    // Used to establish initial head or SHARED marker
        }

        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

    public final void acquire(int arg) {

    }

    public boolean tryAcquire(int arg) {
        return false;
    }

    // 抢占锁失败，会添加一个节点到队列尾部
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);

        Node pre = tail;

        if (pre != null) {
            node.prev = pre;
            // CAS的方式设置尾节点
            if (compareAndSetTail(pre, node)) {
                pre.next = node;
                return node;
            }
        }
        // TODO 自旋操作
        return node;
    }

    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                // 找当前节点的prev节点
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
